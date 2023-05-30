package com.example.domain.repository

import com.example.domain.model.ProfileModel

//TODO удалить
interface ProfileRepository {

    suspend fun loadProfile(): ProfileModel

}