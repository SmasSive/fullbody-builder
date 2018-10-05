package com.smassive.fullbodybuilder.workout.presentation.add.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.smassive.fullbodybuilder.core.presentation.viewmodel.BaseViewModel
import com.smassive.fullbodybuilder.workout.domain.usecase.SaveWorkoutUseCase

class NewWorkoutViewModel(application: Application, private val saveWorkoutUseCase: SaveWorkoutUseCase) : BaseViewModel(application) {

  private val newWorkoutResult: MutableLiveData<Boolean> = MutableLiveData()

  fun saveWorkout(name: String): MutableLiveData<Boolean> {
    persistWorkout(name)
    return newWorkoutResult
  }

  private fun persistWorkout(name: String) {
    saveWorkoutUseCase.saveWorkout(name).execute({ newWorkoutResult.postValue(true) }, { newWorkoutResult.postValue(false) })
  }
}