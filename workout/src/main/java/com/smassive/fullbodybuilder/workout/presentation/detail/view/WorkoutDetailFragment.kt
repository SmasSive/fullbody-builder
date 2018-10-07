package com.smassive.fullbodybuilder.workout.presentation.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smassive.fullbodybuilder.core.util.hideKeyboard
import com.smassive.fullbodybuilder.core.util.observeNonNull
import com.smassive.fullbodybuilder.workout.R
import com.smassive.fullbodybuilder.workout.presentation.detail.model.DayModel
import com.smassive.fullbodybuilder.workout.presentation.detail.model.WorkoutDetailModel
import com.smassive.fullbodybuilder.workout.presentation.detail.viewmodel.WorkoutDetailViewModel
import kotlinx.android.synthetic.main.weekdays_picker.view.dayFr
import kotlinx.android.synthetic.main.weekdays_picker.view.dayMo
import kotlinx.android.synthetic.main.weekdays_picker.view.daySa
import kotlinx.android.synthetic.main.weekdays_picker.view.daySu
import kotlinx.android.synthetic.main.weekdays_picker.view.dayTh
import kotlinx.android.synthetic.main.weekdays_picker.view.dayTu
import kotlinx.android.synthetic.main.weekdays_picker.view.dayWe
import kotlinx.android.synthetic.main.workout_detail_fragment.saveWorkoutAction
import kotlinx.android.synthetic.main.workout_detail_fragment.toolbar
import kotlinx.android.synthetic.main.workout_detail_fragment.workoutDetailDays
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EXTRA_WORKOUT_ID = "EXTRA_WORKOUT_ID"

class WorkoutDetailFragment : Fragment() {

  private val workoutDetailDetailViewModel: WorkoutDetailViewModel by viewModel()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.workout_detail_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    (activity as? AppCompatActivity)?.let {
      it.setSupportActionBar(toolbar)
      it.supportActionBar?.setDisplayShowTitleEnabled(true)
      it.supportActionBar?.setHomeButtonEnabled(true)
      it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    val workoutId = arguments?.getInt(EXTRA_WORKOUT_ID)
    workoutId?.let {
      workoutDetailDetailViewModel.loadWorkout(it)
    } ?: findNavController().navigateUp()

    workoutDetailDetailViewModel.getWorkout().observeNonNull(this) { workoutDetailModel ->
      toolbar.title = workoutDetailModel.name
      workoutDetailModel.days.map { day ->
        when (day) {
          DayModel.Monday -> workoutDetailDays.dayMo.isChecked = true
          DayModel.Tuesday -> workoutDetailDays.dayTu.isChecked = true
          DayModel.Wednesday -> workoutDetailDays.dayWe.isChecked = true
          DayModel.Thursday -> workoutDetailDays.dayTh.isChecked = true
          DayModel.Friday -> workoutDetailDays.dayFr.isChecked = true
          DayModel.Saturday -> workoutDetailDays.daySa.isChecked = true
          DayModel.Sunday -> workoutDetailDays.daySu.isChecked = true
        }
      }

      saveWorkoutAction.setOnClickListener {
        workoutDetailDetailViewModel.saveWorkout(createWorkout()).observeNonNull(this) { newWorkoutResult ->
          when (newWorkoutResult) {
            true -> findNavController().navigateUp()
            false -> TODO("Show error")
          }
        }
      }
    }
  }

  private fun createWorkout(): WorkoutDetailModel {
    val days = mutableListOf<DayModel>()
    if (workoutDetailDays.dayMo.isChecked) days.add(DayModel.Monday)
    if (workoutDetailDays.dayTu.isChecked) days.add(DayModel.Tuesday)
    if (workoutDetailDays.dayWe.isChecked) days.add(DayModel.Wednesday)
    if (workoutDetailDays.dayTh.isChecked) days.add(DayModel.Thursday)
    if (workoutDetailDays.dayFr.isChecked) days.add(DayModel.Friday)
    if (workoutDetailDays.daySa.isChecked) days.add(DayModel.Saturday)
    if (workoutDetailDays.daySu.isChecked) days.add(DayModel.Sunday)

    return WorkoutDetailModel(toolbar.title.toString(), days)
  }

  override fun onStop() {
    hideKeyboard()
    super.onStop()
  }
}
