package com.example.data.di

import com.example.data.local.ProfileService
import com.example.data.repository.ProfileRepositoryImpl
import com.example.domain.interactor.ProfileInteractor
import com.example.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ProfileModule {

    @Provides
    @ViewModelScoped
    fun bindProfileRepository(
        profileService: ProfileService
    ): ProfileRepository = ProfileRepositoryImpl(profileService)

    @Provides
    @ViewModelScoped
    fun bindProfileInteractor(
        profileRepository: ProfileRepository
    ): ProfileInteractor = ProfileInteractor(profileRepository)

}