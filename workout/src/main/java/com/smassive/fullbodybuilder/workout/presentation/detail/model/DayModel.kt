package com.smassive.fullbodybuilder.workout.presentation.detail.model

sealed class DayModel {
  object Monday : DayModel()
  object Tuesday : DayModel()
  object Wednesday : DayModel()
  object Thursday : DayModel()
  object Friday : DayModel()
  object Saturday : DayModel()
  object Sunday : DayModel()
}