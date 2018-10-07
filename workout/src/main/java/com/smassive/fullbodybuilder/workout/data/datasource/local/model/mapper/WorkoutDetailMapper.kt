package com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper

import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail

class WorkoutDetailMapper {

  fun map(workoutDetail: WorkoutDetail): WorkoutEntity {
    return with(workoutDetail) {
      WorkoutEntity(id, name)
    }
  }
}