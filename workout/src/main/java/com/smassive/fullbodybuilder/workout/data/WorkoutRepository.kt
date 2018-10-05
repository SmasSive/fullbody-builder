package com.smassive.fullbodybuilder.workout.data

import com.smassive.fullbodybuilder.workout.data.datasource.local.WorkoutDao
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutEntityMapper
import com.smassive.fullbodybuilder.workout.domain.model.Workout
import io.reactivex.Flowable

class WorkoutRepository(private val workoutDao: WorkoutDao, private val workoutEntityMapper: WorkoutEntityMapper) {

  fun getAllWorkouts(): Flowable<List<Workout>> {
    return workoutDao.loadWorkout().map { workoutEntityMapper.map(it) }
  }

  fun saveWorkout(name: String) {
    workoutDao.saveWorkout(WorkoutEntity(name = name))
  }
}