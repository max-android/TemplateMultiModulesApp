package com.example.data.dto.shows

import com.example.data.dto.peoples.person.PeopleDto
import com.squareup.moshi.Json

class CrewDto(
    @Json(name="type")
    val typeCrew: String? = null,

    @Json(name="person")
    val people: PeopleDto? = null
)