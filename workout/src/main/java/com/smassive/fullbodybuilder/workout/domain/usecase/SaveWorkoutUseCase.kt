package com.smassive.fullbodybuilder.workout.domain.usecase

import com.smassive.fullbodybuilder.workout.data.WorkoutRepository
import io.reactivex.Completable

class SaveWorkoutUseCase(private val workoutRepository: WorkoutRepository) {

  fun saveWorkout(name: String): Completable {
    return Completable.fromCallable { workoutRepository.saveWorkout(name) }
  }
}