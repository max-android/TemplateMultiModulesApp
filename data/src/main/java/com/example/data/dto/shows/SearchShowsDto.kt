package com.example.data.dto.shows

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SearchShowsDto(
    @Json(name = "show")
    val show: ShowDto
)