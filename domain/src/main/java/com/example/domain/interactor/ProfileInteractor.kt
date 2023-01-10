package com.example.domain.interactor

import com.example.domain.repository.ProfileRepository
import com.example.domain.model.ProfileModel
import javax.inject.Inject
import javax.inject.Singleton

// поработать с di
@Singleton
class ProfileInteractor @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    suspend fun loadProfile(): ProfileModel = profileRepository.loadProfile()

}