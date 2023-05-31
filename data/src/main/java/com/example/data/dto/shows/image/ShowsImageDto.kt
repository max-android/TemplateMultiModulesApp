package com.example.data.dto.shows.image

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ShowsImageDto(
    @Json(name = "resolutions")
    val resolutions: ResolutionsImageDto? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "type")
    val type: String? = null
)
