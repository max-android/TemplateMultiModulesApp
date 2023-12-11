package com.example.domain.interactor

import com.example.domain.model.ProfileModel
import com.example.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileInteractor @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    fun profile(): ProfileModel = profileRepository.profile()

    fun updateProfile(profileModel: ProfileModel) {
        profileRepository.updateProfile(profileModel)
    }
}