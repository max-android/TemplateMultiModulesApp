package com.example.data.dto.shows.seasons

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SeasonsImageDto(

    @Json(name = "original")
    val original: String? = null,

    @Json(name = "medium")
    val medium: String? = null
)