package com.example.data.dto.shows

import com.example.data.dto.peoples.characters.CharacterDto
import com.example.data.dto.peoples.person.PeopleDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CastDto(
    @Json(name = "person")
    val person: PeopleDto? = null,

    @Json(name = "character")
    val character: CharacterDto? = null
)