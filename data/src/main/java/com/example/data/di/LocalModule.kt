package com.example.data.di

import android.content.Context
import com.example.data.local.ProfileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideProfileService(@ApplicationContext appContext: Context): ProfileService = ProfileService(appContext)

}