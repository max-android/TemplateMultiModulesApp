package com.example.data

import android.content.Context

class ApiService(private val applicationContext: Context) {

    suspend fun loadProfile(): ProfileDto {
        return ProfileDto("name", 50)
    }

}