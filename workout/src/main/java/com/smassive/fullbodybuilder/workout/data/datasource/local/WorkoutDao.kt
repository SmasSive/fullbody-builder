package com.smassive.fullbodybuilder.workout.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import io.reactivex.Flowable

@Dao
interface WorkoutDao {

  @Query("SELECT * FROM workout")
  fun loadWorkout(): Flowable<List<WorkoutEntity>>

  @Insert
  fun saveWorkout(workoutEntity: WorkoutEntity)

  @Insert
  fun insertAll(workoutEntities: List<WorkoutEntity>)
}