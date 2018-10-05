package com.smassive.fullbodybuilder.workout.presentation.list.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smassive.fullbodybuilder.workout.R
import com.smassive.fullbodybuilder.workout.domain.model.Workout
import com.smassive.fullbodybuilder.workout.presentation.list.model.WorkoutListItemModel
import kotlinx.android.synthetic.main.item_workout.view.workoutName
import kotlinx.android.synthetic.main.item_workout.view.workoutNew

class WorkoutAdapter(
    private val workouts: List<WorkoutListItemModel>,
    private val onWorkoutSelected: (Workout) -> Unit
) : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_workout, parent, false), onWorkoutSelected)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(workouts[position])
  }

  override fun getItemCount(): Int {
    return workouts.size
  }

  class ViewHolder(
      private val view: View,
      private val onClick: (Workout) -> Unit
  ) : RecyclerView.ViewHolder(view) {

    fun bind(workoutListItemModel: WorkoutListItemModel) {
      view.workoutName.text = workoutListItemModel.name
      view.workoutNew.visibility = View.GONE
    }
  }
}