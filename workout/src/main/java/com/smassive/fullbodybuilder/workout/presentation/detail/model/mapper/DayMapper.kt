package com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper

import com.smassive.fullbodybuilder.workout.domain.model.Day
import com.smassive.fullbodybuilder.workout.presentation.detail.model.DayModel

class DayMapper {

  fun map(dayModels: List<DayModel>): List<Day> {
    return dayModels.map { map(it) }
  }

  private fun map(dayModel: DayModel): Day {
    return when (dayModel) {
      DayModel.Monday -> Day.Monday
      DayModel.Tuesday -> Day.Tuesday
      DayModel.Wednesday -> Day.Wednesday
      DayModel.Thursday -> Day.Thursday
      DayModel.Friday -> Day.Friday
      DayModel.Saturday -> Day.Saturday
      DayModel.Sunday -> Day.Sunday
    }
  }
}