package com.smassive.fullbodybuilder.workout.domain.usecase

import com.smassive.fullbodybuilder.workout.data.WorkoutRepository
import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail
import io.reactivex.Completable

class SaveWorkoutUseCase(private val workoutRepository: WorkoutRepository) {

  fun saveWorkout(workoutDetail: WorkoutDetail): Completable {
    return Completable.fromCallable { workoutRepository.saveWorkout(workoutDetail) }
  }
}