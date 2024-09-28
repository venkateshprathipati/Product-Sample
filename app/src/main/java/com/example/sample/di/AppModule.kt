package com.example.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//@Provides
//fun providesDispatchers():AppDispatchers = AppDispatchers
}