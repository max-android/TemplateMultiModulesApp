package com.example.template.di

import com.example.data.ProfileRepositoryImpl
import com.example.domain.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileModule {

    @Binds
    abstract fun bindProfileRepo(
        profileRepositoryImpl: ProfileRepositoryImpl
    ): ProfileRepository

}