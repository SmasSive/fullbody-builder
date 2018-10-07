package com.smassive.fullbodybuilder.workout.infrastructure.di

import com.smassive.fullbodybuilder.workout.domain.usecase.GetWorkoutUseCase
import com.smassive.fullbodybuilder.workout.domain.usecase.GetWorkoutsUseCase
import com.smassive.fullbodybuilder.workout.domain.usecase.SaveWorkoutUseCase
import com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper.DayMapper
import com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper.DayModelMapper
import com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper.WorkoutDetailMapper
import com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper.WorkoutDetailModelMapper
import com.smassive.fullbodybuilder.workout.presentation.detail.viewmodel.WorkoutDetailViewModel
import com.smassive.fullbodybuilder.workout.presentation.list.model.mapper.WorkoutListItemModelMapper
import com.smassive.fullbodybuilder.workout.presentation.list.model.mapper.WorkoutListModelMapper
import com.smassive.fullbodybuilder.workout.presentation.list.viewmodel.WorkoutListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val workoutPresentationModule = module {

  viewModel { WorkoutListViewModel(get(), get(), get(), get()) }

  factory { GetWorkoutsUseCase(get()) }

  factory { WorkoutListModelMapper(get()) }

  factory { WorkoutListItemModelMapper() }

  viewModel { WorkoutDetailViewModel(get(), get(), get(), get(), get()) }

  factory { GetWorkoutUseCase(get()) }

  factory { SaveWorkoutUseCase(get()) }

  factory { WorkoutDetailModelMapper(get()) }

  factory { WorkoutDetailMapper(get()) }

  factory { DayMapper() }

  factory { DayModelMapper() }
}