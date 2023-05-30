package com.example.data.repository

import com.example.data.mapper.toProfileModel
import com.example.data.network.old.ApiService
import com.example.domain.model.ProfileModel
import com.example.domain.repository.ProfileRepository
import javax.inject.Inject

//TODO удалить
class ProfileRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProfileRepository {

    override suspend fun loadProfile(): ProfileModel {
        return apiService.loadProfile().toProfileModel()
    }
}