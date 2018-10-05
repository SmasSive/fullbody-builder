package com.smassive.fullbodybuilder.core.presentation.providers

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class DateProvider {

  companion object {
    const val PATTERN_WEEK_OF_YEAR = "ww"
  }

  fun provideDateOfPattern(pattern: String): String {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern))
  }
}