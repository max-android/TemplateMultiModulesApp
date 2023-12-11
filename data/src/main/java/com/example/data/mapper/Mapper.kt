package com.example.data.mapper

import com.example.data.dto.ProfileDto
import com.example.domain.model.ProfileModel

fun ProfileDto.toProfileModel(): ProfileModel {
    return ProfileModel(this.name, "", this.age)
}