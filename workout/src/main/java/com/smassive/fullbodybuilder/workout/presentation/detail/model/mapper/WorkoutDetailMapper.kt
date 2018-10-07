package com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper

import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail
import com.smassive.fullbodybuilder.workout.presentation.detail.model.WorkoutDetailModel

class WorkoutDetailMapper(private val dayMapper: DayMapper) {

  fun map(workoutDetailModel: WorkoutDetailModel, workoutId: Int): WorkoutDetail {
    return with(workoutDetailModel) {
      WorkoutDetail(workoutId, name, dayMapper.map(days))
    }
  }
}