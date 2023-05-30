package com.example.data.di

import com.example.data.network.TvShowsRestService
import com.example.data.repository.PeoplesRepositoryImpl
import com.example.data.repository.ShowsRepositoryImpl
import com.example.domain.interactor.PeoplesInteractor
import com.example.domain.interactor.ShowsInteractor
import com.example.domain.repository.PeoplesRepository
import com.example.domain.repository.ShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PeoplesModule {

    @Provides
    @ViewModelScoped
    fun bindPeoplesRepo(
        @NetworkModule.ShowsRemoteApi tvShowsRestService: TvShowsRestService
    ): PeoplesRepository = PeoplesRepositoryImpl(tvShowsRestService)

    @Provides
    @ViewModelScoped
    fun bindPeoplesInteractor(
        peoplesRepository: PeoplesRepository
    ): PeoplesInteractor = PeoplesInteractor(peoplesRepository)

}