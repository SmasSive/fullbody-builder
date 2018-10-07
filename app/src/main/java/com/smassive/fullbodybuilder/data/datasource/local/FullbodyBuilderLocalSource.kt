package com.smassive.fullbodybuilder.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smassive.fullbodybuilder.workout.data.datasource.local.DayDao
import com.smassive.fullbodybuilder.workout.data.datasource.local.WorkoutDao
import com.smassive.fullbodybuilder.workout.data.datasource.local.WorkoutDayDao
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutDayEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity

const val DB_NAME = "fullbodybuilder.db"

@Database(entities = [WorkoutEntity::class, DayEntity::class, WorkoutDayEntity::class], version = 1)
abstract class FullbodyBuilderLocalSource : RoomDatabase() {
  abstract fun workoutDao(): WorkoutDao
  abstract fun dayDao(): DayDao
  abstract fun workoutDayDao(): WorkoutDayDao
}