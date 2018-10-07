package com.smassive.fullbodybuilder.workout.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayEntity
import io.reactivex.Single

@Dao
interface DayDao {

  @Query("SELECT * FROM day")
  fun loadDays(): Single<List<DayEntity>>

  @Insert
  fun insertAll(dayEntities: List<DayEntity>)
}