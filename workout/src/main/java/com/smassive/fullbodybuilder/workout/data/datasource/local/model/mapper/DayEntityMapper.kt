package com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper

import com.smassive.fullbodybuilder.workout.data.datasource.local.DayNotSupportedException
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayEntity
import com.smassive.fullbodybuilder.workout.domain.model.Day

class DayEntityMapper {

  fun map(dayEntities: List<DayEntity>): List<Day> {
    return dayEntities.map { map(it) }
  }

  private fun map(dayEntity: DayEntity): Day {
    return when (dayEntity.id) {
      1 -> Day.Monday
      2 -> Day.Tuesday
      3 -> Day.Wednesday
      4 -> Day.Thursday
      5 -> Day.Friday
      6 -> Day.Saturday
      7 -> Day.Sunday
      else -> throw DayNotSupportedException(dayEntity.name)
    }
  }
}