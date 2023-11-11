package com.example.data.dto.players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GamesDto(
    @Json(name = "data")
    val data: List<GameDto?>? = null
)