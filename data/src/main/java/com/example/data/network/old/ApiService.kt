package com.example.data.network.old

import android.content.Context
import com.example.data.dto.ProfileDto

class ApiService(private val applicationContext: Context) {

    suspend fun loadProfile(): ProfileDto {
        return ProfileDto("name", 50)
    }

}