package com.smassive.fullbodybuilder.workout.presentation.list.model.mapper

import com.smassive.fullbodybuilder.workout.domain.model.Workout
import com.smassive.fullbodybuilder.workout.presentation.list.model.WorkoutListModel

class WorkoutListModelMapper(private val workoutListItemModelMapper: WorkoutListItemModelMapper) {

  fun map(workouts: List<Workout>, currentWeekInYear: String): WorkoutListModel {
    return WorkoutListModel(workoutListItemModelMapper.map(workouts), currentWeekInYear.toInt() - 1)
  }
}