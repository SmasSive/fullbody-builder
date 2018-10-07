package com.smassive.fullbodybuilder.workout.domain.model

sealed class Day {
  object Monday : Day()
  object Tuesday : Day()
  object Wednesday : Day()
  object Thursday : Day()
  object Friday : Day()
  object Saturday : Day()
  object Sunday : Day()
}