package com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper

import com.smassive.fullbodybuilder.workout.data.datasource.local.model.DayDataModel
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutDayEntity
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import com.smassive.fullbodybuilder.workout.domain.model.Day

class WorkoutDayMapper {

  fun map(workoutEntity: WorkoutEntity, days: List<Day>): Array<WorkoutDayEntity> {
    return days.map { day ->
      when (day) {
        Day.Monday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.MondayDataModel.id)
        Day.Tuesday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.TuesdayDataModel.id)
        Day.Wednesday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.WednesdayDataModel.id)
        Day.Thursday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.ThursdayDataModel.id)
        Day.Friday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.FridayDataModel.id)
        Day.Saturday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.SaturdayDataModel.id)
        Day.Sunday -> WorkoutDayEntity(workoutEntity.id, DayDataModel.SundayDataModel.id)
      }
    }.toTypedArray()
  }
}