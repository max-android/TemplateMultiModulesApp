package com.example.data.di

import com.example.data.network.QuoteRestService
import com.example.data.repository.QuoteRepositoryImpl
import com.example.domain.interactor.QuoteInteractor
import com.example.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object QuoteModule {

    @Provides
    @ViewModelScoped
    fun bindQuoteRepo(
        @NetworkModule.QuoteRemoteApi quoteRestService: QuoteRestService
    ): QuoteRepository = QuoteRepositoryImpl(quoteRestService)

    @Provides
    @ViewModelScoped
    fun bindQuoteInteractor(
        quoteRepository: QuoteRepository
    ): QuoteInteractor = QuoteInteractor(quoteRepository)

}