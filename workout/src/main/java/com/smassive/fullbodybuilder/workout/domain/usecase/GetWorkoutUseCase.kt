package com.smassive.fullbodybuilder.workout.domain.usecase

import com.smassive.fullbodybuilder.workout.data.WorkoutRepository
import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail
import io.reactivex.Single

class GetWorkoutUseCase(private val workoutRepository: WorkoutRepository) {

  fun getWorkout(id: Int): Single<WorkoutDetail> {
    return workoutRepository.getWorkout(id)
  }
}