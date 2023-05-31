package com.example.data.di

import com.example.data.network.OpenCollectiveRestService
import com.example.data.repository.OpenCollectiveRepositoryImpl
import com.example.domain.interactor.OpenCollectiveInteractor
import com.example.domain.repository.OpenCollectiveRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OpenCollectiveModule {

    @Provides
    @ViewModelScoped
    fun bindOpenCollectiveRepo(
        @NetworkModule.OpenCollectiveRemoteApi openCollectiveRestService: OpenCollectiveRestService
    ): OpenCollectiveRepository = OpenCollectiveRepositoryImpl(openCollectiveRestService)

    @Provides
    @ViewModelScoped
    fun bindOpenCollectiveInteractor(
        openCollectiveRepository: OpenCollectiveRepository
    ): OpenCollectiveInteractor = OpenCollectiveInteractor(openCollectiveRepository)

}