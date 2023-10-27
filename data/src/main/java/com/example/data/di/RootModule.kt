package com.example.data.di

import com.example.data.network.PunkapiRestService
import com.example.data.repository.BeerRepositoryImpl
import com.example.domain.interactor.BeerInteractor
import com.example.domain.repository.BeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RootModule {

    @Provides
    @ViewModelScoped
    fun bindBeerRepo(
        @NetworkModule.PunkapiRemoteApi punkapiRestService: PunkapiRestService
    ): BeerRepository = BeerRepositoryImpl(punkapiRestService)

    @Provides
    @ViewModelScoped
    fun bindBeerInteractor(
        beerRepository: BeerRepository
    ): BeerInteractor = BeerInteractor(beerRepository)

}