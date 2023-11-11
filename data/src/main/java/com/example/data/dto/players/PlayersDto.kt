package com.example.data.dto.players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PlayersDto(
    @Json(name = "data")
    val data: List<PlayerDto?>? = null,
)