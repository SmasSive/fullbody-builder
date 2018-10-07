package com.smassive.fullbodybuilder.workout.data.datasource.local

class DayNotSupportedException(dayName: String) : RuntimeException("Day $dayName not supported")