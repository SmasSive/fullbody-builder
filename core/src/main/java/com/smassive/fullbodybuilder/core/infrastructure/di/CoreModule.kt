package com.smassive.fullbodybuilder.core.infrastructure.di

import com.smassive.fullbodybuilder.core.presentation.providers.DateProvider
import org.koin.dsl.module.module

val coreModule = module {

  single { DateProvider() }
}
