package com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper

import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import com.smassive.fullbodybuilder.workout.domain.model.Workout

class WorkoutEntityMapper {

  fun map(workoutEntities: List<WorkoutEntity>): List<Workout> {
    return workoutEntities.map { Workout(it.id, it.name) }
  }
}