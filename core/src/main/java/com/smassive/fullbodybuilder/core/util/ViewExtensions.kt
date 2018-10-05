package com.smassive.fullbodybuilder.core.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
  activity?.hideKeyboard()
}

fun Activity.hideKeyboard() {
  hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
}

fun Context.hideKeyboard(view: View) {
  val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
