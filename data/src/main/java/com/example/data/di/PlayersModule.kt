package com.example.data.di

import com.example.data.network.PlayersRestService
import com.example.data.repository.PlayersRepositoryImpl
import com.example.domain.interactor.PlayersInteractor
import com.example.domain.repository.PlayersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PlayersModule {

    @Provides
    @ViewModelScoped
    fun bindPlayersRepo(
        @NetworkModule.PlayersRemoteApi playersRestService: PlayersRestService
    ): PlayersRepository = PlayersRepositoryImpl(playersRestService)

    @Provides
    @ViewModelScoped
    fun bindPlayersInteractor(
        playersRepository: PlayersRepository
    ): PlayersInteractor = PlayersInteractor(playersRepository)

}