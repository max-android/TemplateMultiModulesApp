package com.example.domain.repository

import com.example.domain.model.ProfileModel

interface ProfileRepository {

    fun profile(): ProfileModel

    fun updateProfile(profileModel: ProfileModel)

}