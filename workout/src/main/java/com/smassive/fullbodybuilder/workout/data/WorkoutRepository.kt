package com.smassive.fullbodybuilder.workout.data

import com.smassive.fullbodybuilder.workout.data.datasource.local.WorkoutDao
import com.smassive.fullbodybuilder.workout.data.datasource.local.WorkoutDayDao
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutDayMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutDetailEntityMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutDetailMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutEntityMapper
import com.smassive.fullbodybuilder.workout.domain.model.Workout
import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class WorkoutRepository(
    private val workoutDao: WorkoutDao,
    private val workoutDayDao: WorkoutDayDao,
    private val workoutEntityMapper: WorkoutEntityMapper,
    private val workoutDetailEntityMapper: WorkoutDetailEntityMapper,
    private val workoutDetailMapper: WorkoutDetailMapper,
    private val workoutDayMapper: WorkoutDayMapper
) {

  fun getAllWorkouts(): Flowable<List<Workout>> {
    return workoutDao.loadWorkouts().map { workoutEntityMapper.map(it) }
  }

  fun getWorkout(id: Int): Single<WorkoutDetail> {
    return workoutDao.loadWorkout(id)
        .zipWith(workoutDayDao.getDaysForWorkout(id),
            BiFunction { workoutEntity: WorkoutEntity, days: List<DayEntity> -> workoutDetailEntityMapper.map(workoutEntity, days) })
  }

  fun saveWorkout(workoutDetail: WorkoutDetail) {
    workoutDetailMapper.map(workoutDetail).let { workoutEntity ->
      workoutDao.saveWorkout(workoutEntity)
      workoutDayDao.removeWorkoutDays(*workoutDayDao.getWorkoutDays(workoutEntity.id).toTypedArray())
      workoutDayDao.saveWorkoutDay(*workoutDayMapper.map(workoutEntity, workoutDetail.days))
    }
  }
}