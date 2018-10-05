package com.smassive.fullbodybuilder.infrastructure.di

import android.app.Application
import com.smassive.fullbodybuilder.infrastructure.FullbodyBuilderApplication
import org.koin.dsl.module.module

val appModule = module {
  single { get<Application>() as FullbodyBuilderApplication }
}