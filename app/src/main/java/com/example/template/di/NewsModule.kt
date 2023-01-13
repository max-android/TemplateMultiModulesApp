package com.example.template.di

import com.example.data.network.NewsRestService
import com.example.data.repository.NewsRepositoryImpl
import com.example.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Provides
    @Singleton
    fun bindNewsRepo(
        @NetworkModule.NewsRemoteApi newsRestService: NewsRestService
    ): NewsRepository = NewsRepositoryImpl(newsRestService)

}