package com.smassive.fullbodybuilder.workout.infrastructure.di

import com.smassive.fullbodybuilder.workout.data.WorkoutRepository
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.mapper.WorkoutEntityMapper
import com.smassive.fullbodybuilder.workout.domain.usecase.GetWorkoutsUseCase
import com.smassive.fullbodybuilder.workout.domain.usecase.SaveWorkoutUseCase
import com.smassive.fullbodybuilder.workout.presentation.add.viewmodel.NewWorkoutViewModel
import com.smassive.fullbodybuilder.workout.presentation.list.model.mapper.WorkoutListItemModelMapper
import com.smassive.fullbodybuilder.workout.presentation.list.model.mapper.WorkoutListModelMapper
import com.smassive.fullbodybuilder.workout.presentation.list.viewmodel.WorkoutListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val workoutModule = module {

  viewModel { WorkoutListViewModel(get(), get(), get(), get()) }

  viewModel { NewWorkoutViewModel(get(), get()) }

  factory { GetWorkoutsUseCase(get()) }

  factory { SaveWorkoutUseCase(get()) }

  factory { WorkoutRepository(get(), get()) }

  factory { WorkoutEntityMapper() }

  factory { WorkoutListModelMapper(get()) }

  factory { WorkoutListItemModelMapper() }
}