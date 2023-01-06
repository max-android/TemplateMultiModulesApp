package com.example.data

import com.example.domain.ProfileModel
import com.example.domain.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProfileRepository {

    override suspend fun loadProfile(): ProfileModel {
        return apiService.loadProfile().toProfileModel()
    }
}