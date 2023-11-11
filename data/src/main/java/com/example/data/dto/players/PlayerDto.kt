package com.example.data.dto.players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PlayerDto(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "first_name")
    val firstName: String? = null,
    @Json(name = "last_name")
    val lastName: String? = null,
    @Json(name = "position")
    val position: String? = null,
    @Json(name = "height_feet")
    val heightFeet: Int? = null,
    @Json(name = "height_inches")
    val heightInches: Int? = null,
    @Json(name = "weight_pounds")
    val weightPounds: Int? = null,
)