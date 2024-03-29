package com.example.data.dto.peoples.characters

import com.example.data.dto.peoples.person.ImagePeopleDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CharacterDto(
    @Json(name="id")
    val id: Int? = null,

    @Json(name="name")
    val name: String? = null,

    @Json(name="image")
    val image: ImagePeopleDto? = null
)