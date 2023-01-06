package com.example.template.di

import android.content.Context
import com.example.navigation.ScreenStarter
import com.example.template.navigation.Starter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideStarter(@ApplicationContext applicationContext: Context): ScreenStarter {
        return Starter(applicationContext)
    }

}