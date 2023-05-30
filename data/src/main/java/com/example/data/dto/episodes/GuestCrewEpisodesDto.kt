package com.example.data.dto.episodes

import com.example.data.dto.peoples.person.PeopleDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GuestCrewEpisodesDto(
    @Json(name = "person")
    val person: PeopleDto? = null,

    @Json(name = "guestCrewType")
    val guestCrewType: String? = null
)