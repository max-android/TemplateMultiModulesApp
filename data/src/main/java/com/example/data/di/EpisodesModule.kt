package com.example.data.di

import com.example.data.network.TvShowsRestService
import com.example.data.repository.EpisodesRepositoryImpl
import com.example.domain.interactor.EpisodesInteractor
import com.example.domain.repository.EpisodesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object EpisodesModule {

    @Provides
    @ViewModelScoped
    fun bindEpisodesRepo(
        @NetworkModule.ShowsRemoteApi tvShowsRestService: TvShowsRestService
    ): EpisodesRepository = EpisodesRepositoryImpl(tvShowsRestService)

    @Provides
    @ViewModelScoped
    fun bindEpisodesInteractor(
        episodesRepository: EpisodesRepository
    ): EpisodesInteractor = EpisodesInteractor(episodesRepository)

}