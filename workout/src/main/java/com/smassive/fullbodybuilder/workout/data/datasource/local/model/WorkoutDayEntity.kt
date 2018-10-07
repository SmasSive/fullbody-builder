package com.smassive.fullbodybuilder.workout.data.datasource.local.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "workout_day",
    primaryKeys = ["workoutId", "dayId"],
    foreignKeys = [
      ForeignKey(entity = WorkoutEntity::class, parentColumns = arrayOf("id"), childColumns = arrayOf("workoutId")),
      ForeignKey(entity = DayEntity::class, parentColumns = arrayOf("id"), childColumns = arrayOf("dayId"))
    ]
)
data class WorkoutDayEntity(val workoutId: Int, val dayId: Int)