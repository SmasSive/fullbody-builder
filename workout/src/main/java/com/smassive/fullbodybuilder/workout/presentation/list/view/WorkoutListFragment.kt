package com.smassive.fullbodybuilder.workout.presentation.list.view

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.rubensousa.gravitysnaphelper.GravityPagerSnapHelper
import com.smassive.fullbodybuilder.core.util.observeNonNull
import com.smassive.fullbodybuilder.workout.R
import com.smassive.fullbodybuilder.workout.presentation.list.model.WorkoutListModel
import com.smassive.fullbodybuilder.workout.presentation.list.view.adapter.WorkoutAdapter
import com.smassive.fullbodybuilder.workout.presentation.list.viewmodel.WorkoutListViewModel
import kotlinx.android.synthetic.main.main_fragment.workoutList
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkoutListFragment : Fragment() {

  private val workoutListViewModel: WorkoutListViewModel by viewModel()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.main_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    workoutListViewModel.getWorkouts().observeNonNull(this) { workout -> configRecyclerAdapter(workout) }
  }

  private fun configRecyclerAdapter(workoutListModel: WorkoutListModel) {
    workoutList.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
    workoutList.adapter = WorkoutAdapter(workoutListModel.workouts) {
      findNavController().navigate(R.id.action_workoutListFragment_to_newWorkoutFragment)
    }
    GravityPagerSnapHelper(Gravity.START, true).attachToRecyclerView(workoutList)
    workoutList.scrollToPosition(workoutListModel.currentListPosition)
  }
}
