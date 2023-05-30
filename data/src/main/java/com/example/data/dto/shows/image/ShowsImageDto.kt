package com.example.data.dto.shows.image

import com.squareup.moshi.Json

class ShowsImageDto(
    @Json(name="resolutions")
    val resolutions: ResolutionsImageDto? = null,

    @Json(name="id")
    val id: Int? = null,

    @Json(name="type")
    val type: String? = null
)
