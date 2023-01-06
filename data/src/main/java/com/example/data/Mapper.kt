package com.example.data

import com.example.domain.ProfileModel

fun ProfileDto.toProfileModel(): ProfileModel {
    return ProfileModel(this.name, this.age)
}