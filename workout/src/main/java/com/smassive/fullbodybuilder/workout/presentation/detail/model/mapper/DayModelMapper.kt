package com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper

import com.smassive.fullbodybuilder.workout.domain.model.Day
import com.smassive.fullbodybuilder.workout.presentation.detail.model.DayModel

class DayModelMapper {

  fun map(days: List<Day>): List<DayModel> {
    return days.map { map(it) }
  }

  private fun map(day: Day): DayModel {
    return when (day) {
      Day.Monday -> DayModel.Monday
      Day.Tuesday -> DayModel.Tuesday
      Day.Wednesday -> DayModel.Wednesday
      Day.Thursday -> DayModel.Thursday
      Day.Friday -> DayModel.Friday
      Day.Saturday -> DayModel.Saturday
      Day.Sunday -> DayModel.Sunday
    }
  }
}