package com.smassive.fullbodybuilder.workout.presentation.list.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.smassive.fullbodybuilder.workout.R
import kotlinx.android.synthetic.main.item_workout_step_1.view.nextStep2
import moe.feng.common.stepperview.IStepperAdapter
import moe.feng.common.stepperview.VerticalStepperItemView
import moe.feng.common.stepperview.VerticalStepperView

class WorkoutStepperAdapter(private val workoutStepper: VerticalStepperView) : IStepperAdapter {

  override fun onCreateCustomView(index: Int, context: Context, parent: VerticalStepperItemView): View? {
    return when (index) {
      0 -> createFirstStepView(context, parent)
      else -> createFirstStepView(context, parent)
    }
  }

  private fun createFirstStepView(context: Context, parent: VerticalStepperItemView): View {
    val view = LayoutInflater.from(context).inflate(R.layout.item_workout_step_1, parent, false)
    view.nextStep2.setOnClickListener { workoutStepper.nextStep() }
    return view
  }

  override fun getSummary(index: Int): CharSequence? {
    return when (index) {
      0 -> "Which days you want to work"
      else -> "TODO"
    }
  }

  override fun getTitle(index: Int): CharSequence {
    return when (index) {
      0 -> "Workout days"
      else -> "TODO"
    }
  }

  override fun size(): Int {
    return 2
  }

  override fun onShow(index: Int) {
  }

  override fun onHide(index: Int) {
  }

}