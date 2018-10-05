package com.smassive.fullbodybuilder.workout.domain.usecase

import com.smassive.fullbodybuilder.workout.data.WorkoutRepository
import com.smassive.fullbodybuilder.workout.domain.model.Workout
import io.reactivex.Flowable

class GetWorkoutsUseCase(private val workoutRepository: WorkoutRepository) {

  fun getAllWorkouts(): Flowable<List<Workout>> {
    return workoutRepository.getAllWorkouts()
  }
}