package com.example.template.di

import android.content.Context
import com.example.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideStarter(@ApplicationContext applicationContext: Context): ApiService {
        return ApiService(applicationContext)
    }

}