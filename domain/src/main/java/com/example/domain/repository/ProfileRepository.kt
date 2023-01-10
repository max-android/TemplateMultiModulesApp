package com.example.domain.repository

import com.example.domain.model.ProfileModel

interface ProfileRepository {

    suspend fun loadProfile(): ProfileModel

}