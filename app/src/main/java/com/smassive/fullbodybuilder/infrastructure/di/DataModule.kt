package com.smassive.fullbodybuilder.infrastructure.di

import androidx.room.Room
import com.smassive.fullbodybuilder.data.datasource.local.DB_NAME
import com.smassive.fullbodybuilder.data.datasource.local.DbPrepopulator
import com.smassive.fullbodybuilder.data.datasource.local.FullbodyBuilderLocalSource
import org.koin.dsl.module.module

val dataModule = module {

  single { Room.databaseBuilder(get(), FullbodyBuilderLocalSource::class.java, DB_NAME).addCallback(get<DbPrepopulator>()).build() }

  single { DbPrepopulator(get(), lazy { get<FullbodyBuilderLocalSource>() }) }

  single { get<FullbodyBuilderLocalSource>().workoutDao() }
}