package com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper

import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail

class WorkoutDetailEntityMapper(private val dayEntityMapper: DayEntityMapper) {

  fun map(
      workoutEntity: WorkoutEntity,
      days: List<DayEntity>
  ): WorkoutDetail {
    return with(workoutEntity) {
      WorkoutDetail(id, name, dayEntityMapper.map(days))
    }
  }
}