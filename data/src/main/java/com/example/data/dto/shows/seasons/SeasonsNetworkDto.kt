package com.example.data.dto.shows.seasons

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SeasonsNetworkDto(

    @Json(name = "officialSite")
    val officialSite: String? = null
)