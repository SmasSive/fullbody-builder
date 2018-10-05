package com.smassive.fullbodybuilder.workout.domain.model

sealed class Workout(open val name: String) {
  data class FullWorkout(override val name: String) : Workout(name)
  data class EmptyWorkout(override val name: String = "Add your first workout!") : Workout(name)
}