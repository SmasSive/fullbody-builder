package com.smassive.fullbodybuilder.workout.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout")
data class WorkoutEntity(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                         var name: String = "")