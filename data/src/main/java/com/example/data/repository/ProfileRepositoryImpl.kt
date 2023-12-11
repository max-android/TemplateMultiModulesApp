package com.example.data.repository

import com.example.data.local.ProfileService
import com.example.domain.model.ProfileModel
import com.example.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileService: ProfileService
) : ProfileRepository {

    override fun profile(): ProfileModel {
        val profileName = profileService.profileName
        val profilePhone = profileService.profilePhone
        return ProfileModel(profileName, profilePhone)
    }

    override fun updateProfile(profileModel: ProfileModel) {
        profileService.profileName = profileModel.name
        profileService.profilePhone = profileModel.phone
    }

}