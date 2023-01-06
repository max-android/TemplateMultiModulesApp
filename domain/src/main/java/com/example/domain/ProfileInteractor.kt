package com.example.domain

import javax.inject.Inject
import javax.inject.Singleton

// поработать с di
@Singleton
class ProfileInteractor @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    suspend fun loadProfile(): ProfileModel = profileRepository.loadProfile()

}