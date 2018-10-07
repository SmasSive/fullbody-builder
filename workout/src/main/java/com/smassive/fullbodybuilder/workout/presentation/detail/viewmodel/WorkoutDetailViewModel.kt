package com.smassive.fullbodybuilder.workout.presentation.detail.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.smassive.fullbodybuilder.core.presentation.viewmodel.BaseViewModel
import com.smassive.fullbodybuilder.workout.domain.model.WorkoutDetail
import com.smassive.fullbodybuilder.workout.domain.usecase.GetWorkoutUseCase
import com.smassive.fullbodybuilder.workout.domain.usecase.SaveWorkoutUseCase
import com.smassive.fullbodybuilder.workout.presentation.detail.model.WorkoutDetailModel
import com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper.WorkoutDetailMapper
import com.smassive.fullbodybuilder.workout.presentation.detail.model.mapper.WorkoutDetailModelMapper

class WorkoutDetailViewModel(
    application: Application,
    private val getWorkoutUseCase: GetWorkoutUseCase,
    private val saveWorkoutUseCase: SaveWorkoutUseCase,
    private val workoutDetailModelMapper: WorkoutDetailModelMapper,
    private val workoutDetailMapper: WorkoutDetailMapper
) : BaseViewModel(application) {

  private val workout: MutableLiveData<WorkoutDetailModel> = MutableLiveData()
  private val newWorkoutResult: MutableLiveData<Boolean> = MutableLiveData()

  private var workoutId: Int = 0

  fun getWorkout(): MutableLiveData<WorkoutDetailModel> {
    return workout
  }

  fun loadWorkout(id: Int) {
    workoutId = id
    getWorkoutUseCase.getWorkout(workoutId).execute(onWorkoutRetrieved())
  }

  private fun onWorkoutRetrieved(): (WorkoutDetail) -> Unit = {
    workout.postValue(workoutDetailModelMapper.map(it))
  }

  fun saveWorkout(workoutDetailModel: WorkoutDetailModel): MutableLiveData<Boolean> {
    persistWorkout(workoutDetailModel)
    return newWorkoutResult
  }

  private fun persistWorkout(workoutDetailModel: WorkoutDetailModel) {
    saveWorkoutUseCase.saveWorkout(workoutDetailMapper.map(workoutDetailModel, workoutId))
        .execute({ newWorkoutResult.postValue(true) }, { newWorkoutResult.postValue(false) })
  }
}