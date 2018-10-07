package com.smassive.fullbodybuilder.workout.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutDayEntity
import io.reactivex.Single

@Dao
interface WorkoutDayDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveWorkoutDay(vararg workoutDayEntities: WorkoutDayEntity)

  @Query("SELECT * FROM day INNER JOIN workout_day ON day.id=workout_day.dayId WHERE workout_day.workoutId=:workoutId")
  fun getDaysForWorkout(workoutId: Int): Single<List<DayEntity>>

  @Query("SELECT * FROM workout_day WHERE workout_day.workoutId=:workoutId")
  fun getWorkoutDays(workoutId: Int): List<WorkoutDayEntity>

  @Delete
  fun removeWorkoutDays(vararg workoutDayEntities: WorkoutDayEntity)
}