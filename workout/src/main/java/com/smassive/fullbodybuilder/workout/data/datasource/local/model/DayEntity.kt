package com.smassive.fullbodybuilder.workout.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class DayDataModel(val id: Int) {
  MondayDataModel(1),
  TuesdayDataModel(2),
  WednesdayDataModel(3),
  ThursdayDataModel(4),
  FridayDataModel(5),
  SaturdayDataModel(6),
  SundayDataModel(7)
}

@Entity(tableName = "day")
data class DayEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String = ""
)