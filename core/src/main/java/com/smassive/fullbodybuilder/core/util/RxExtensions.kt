package com.smassive.fullbodybuilder.core.util

import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

val onErrorStub: (Throwable) -> Unit = { Log.e("FBB", "ERROR: $it") }
val onNextStub: (Any) -> Unit = {}
val onCompleteStub: () -> Unit = {}

fun Disposable.addTo(compositeDisposable: CompositeDisposable) = compositeDisposable.add(this)
