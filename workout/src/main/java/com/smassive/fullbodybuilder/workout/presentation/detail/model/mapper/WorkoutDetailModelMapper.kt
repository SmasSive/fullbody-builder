package com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper

import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail
import com.smassive.fullbodybuilder.workout.presentation.detail.model.WorkoutDetailModel

class WorkoutDetailModelMapper(private val dayModelMapper: DayModelMapper) {

  fun map(workoutDetail: WorkoutDetail): WorkoutDetailModel {
    return with(workoutDetail) {
      WorkoutDetailModel(name, dayModelMapper.map(days))
    }
  }
}