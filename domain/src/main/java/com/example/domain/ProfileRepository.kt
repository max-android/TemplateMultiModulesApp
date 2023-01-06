package com.example.domain

interface ProfileRepository {

    suspend fun loadProfile(): ProfileModel

}