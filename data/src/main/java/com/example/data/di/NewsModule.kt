package com.example.data.di

import com.example.data.network.old.NewsRestService
import com.example.data.repository.NewsRepositoryImpl
import com.example.domain.interactor.NewsInteractor
import com.example.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object NewsModule {

    @Provides
    @ViewModelScoped
    fun bindNewsRepo(
        @NetworkModule.NewsRemoteApi newsRestService: NewsRestService
    ): NewsRepository = NewsRepositoryImpl(newsRestService)

    @Provides
    @ViewModelScoped
    fun bindNewsInteractor(
        newsRepository: NewsRepository
    ): NewsInteractor = NewsInteractor(newsRepository)
}