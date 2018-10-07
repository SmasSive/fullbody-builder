package com.smassive.fullbodybuilder.workout.presentation.list.model.mapper

import com.smassive.fullbodybuilder.workout.domain.model.Workout
import com.smassive.fullbodybuilder.workout.presentation.list.model.WorkoutListItemModel

class WorkoutListItemModelMapper {

  fun map(workouts: List<Workout>): List<WorkoutListItemModel> {
    return workouts.map { WorkoutListItemModel(it.id, it.name) }
  }
}