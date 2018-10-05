package com.smassive.fullbodybuilder.core.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

fun <T, R> LiveData<T>.map(transformation: (T?) -> R): LiveData<R> {
  return Transformations.map(this, transformation)
}

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, f: (T) -> Unit) {
  this.observe(owner, androidx.lifecycle.Observer<T> { t -> t?.let(f) })
}