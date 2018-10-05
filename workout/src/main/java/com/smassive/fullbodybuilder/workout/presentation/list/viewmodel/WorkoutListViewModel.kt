package com.smassive.fullbodybuilder.workout.presentation.list.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.smassive.fullbodybuilder.core.presentation.providers.DateProvider
import com.smassive.fullbodybuilder.core.presentation.viewmodel.BaseViewModel
import com.smassive.fullbodybuilder.workout.domain.model.Workout
import com.smassive.fullbodybuilder.workout.domain.usecase.GetWorkoutsUseCase
import com.smassive.fullbodybuilder.workout.presentation.list.model.WorkoutListModel
import com.smassive.fullbodybuilder.workout.presentation.list.model.mapper.WorkoutListModelMapper

class WorkoutListViewModel(
    application: Application,
    private val getWorkoutsUseCase: GetWorkoutsUseCase,
    private val dateProvider: DateProvider,
    private val workoutListModelMapper: WorkoutListModelMapper
) : BaseViewModel(application) {

  private val workouts: MutableLiveData<WorkoutListModel> = MutableLiveData()

  init {
    loadWorkouts()
  }

  fun getWorkouts(): MutableLiveData<WorkoutListModel> {
    return workouts
  }

  private fun loadWorkouts() {
    getWorkoutsUseCase.getAllWorkouts().execute(onWorkoutsRetrieved())
  }

  private fun onWorkoutsRetrieved(): (List<Workout>) -> Unit = {
    val currentWeekInYear = dateProvider.provideDateOfPattern(DateProvider.PATTERN_WEEK_OF_YEAR)
    workouts.postValue(workoutListModelMapper.map(it, currentWeekInYear))
  }
}
