package com.smassive.fullbodybuilder.workout.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface WorkoutDao {

  @Query("SELECT * FROM workout")
  fun loadWorkouts(): Flowable<List<WorkoutEntity>>

  @Query("SELECT * FROM workout WHERE id = :id")
  fun loadWorkout(id: Int): Single<WorkoutEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveWorkout(workoutEntity: WorkoutEntity)

  @Insert
  fun insertAll(workoutEntities: List<WorkoutEntity>)
}