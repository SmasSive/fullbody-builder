package com.smassive.fullbodybuilder.workout.presentation.list.model

data class WorkoutListModel(
    val workouts: List<WorkoutListItemModel>,
    val currentListPosition: Int
)