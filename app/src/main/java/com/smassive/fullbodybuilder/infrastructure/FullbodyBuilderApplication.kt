package com.smassive.fullbodybuilder.infrastructure

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.smassive.fullbodybuilder.core.infrastructure.di.coreModule
import com.smassive.fullbodybuilder.infrastructure.di.appModule
import com.smassive.fullbodybuilder.infrastructure.di.dataModule
import com.smassive.fullbodybuilder.workout.infrastructure.di.workoutModule
import org.koin.android.ext.android.startKoin

class FullbodyBuilderApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin(this, listOf(
        appModule,
        coreModule,
        dataModule,
        workoutModule))

    AndroidThreeTen.init(this)
  }
}