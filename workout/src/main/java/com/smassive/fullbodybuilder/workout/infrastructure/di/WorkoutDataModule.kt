package com.smassive.fullbodybuilder.workout.infrastructure.di

import com.smassive.fullbodybuilder.workout.data.WorkoutRepository
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.DayEntityMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutDayMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutDetailEntityMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutDetailMapper
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutEntityMapper
import org.koin.dsl.module.module

val workoutDataModule = module {

  factory { WorkoutRepository(get(), get(), get(), get(), get(), get()) }

  factory { WorkoutEntityMapper() }

  factory { WorkoutDetailEntityMapper(get()) }

  factory { DayEntityMapper() }

  factory { WorkoutDetailMapper() }

  factory { WorkoutDayMapper() }
}