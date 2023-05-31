package com.example.data.dto.openCollective

import com.squareup.moshi.Json

class EventDto(

    @Json(name = "image")
    val image: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "longDescription")
    val longDescription: String? = null,

    @Json(name = "startsAt")
    val startsAt: String? = null,

    @Json(name = "location")
    val location: LocationEventDto? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "endsAt")
    val endsAt: String? = null,

    @Json(name = "slug")
    val slug: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "info")
    val info: String? = null
)