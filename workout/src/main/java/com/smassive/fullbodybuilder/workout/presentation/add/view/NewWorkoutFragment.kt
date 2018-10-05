package com.smassive.fullbodybuilder.workout.presentation.add.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smassive.fullbodybuilder.core.util.hideKeyboard
import com.smassive.fullbodybuilder.core.util.observeNonNull
import com.smassive.fullbodybuilder.workout.R
import com.smassive.fullbodybuilder.workout.presentation.add.viewmodel.NewWorkoutViewModel
import kotlinx.android.synthetic.main.new_fragment.addWorkoutAction
import kotlinx.android.synthetic.main.new_fragment.addWorkoutName
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewWorkoutFragment : Fragment() {

  private val newWorkoutViewModel: NewWorkoutViewModel by viewModel()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.new_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    addWorkoutAction.setOnClickListener {
      newWorkoutViewModel.saveWorkout(addWorkoutName.text.toString()).observeNonNull(this) { newWorkoutResult ->
        when (newWorkoutResult) {
          true -> findNavController().navigateUp()
          false -> TODO("Show error")
        }
      }
    }
  }

  override fun onStop() {
    hideKeyboard()
    super.onStop()
  }
}
