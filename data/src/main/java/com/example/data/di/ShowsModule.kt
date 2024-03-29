package com.example.data.di

import com.example.data.network.TvShowsRestService
import com.example.data.repository.ShowsRepositoryImpl
import com.example.domain.interactor.ShowsInteractor
import com.example.domain.repository.ShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ShowsModule {

    @Provides
    @ViewModelScoped
    fun bindShowsRepo(
        @NetworkModule.ShowsRemoteApi tvShowsRestService: TvShowsRestService
    ): ShowsRepository = ShowsRepositoryImpl(tvShowsRestService)

    @Provides
    @ViewModelScoped
    fun bindShowsInteractor(
        showsRepository: ShowsRepository
    ): ShowsInteractor = ShowsInteractor(showsRepository)

}