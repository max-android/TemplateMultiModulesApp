package com.example.data.dto.shows.image

import com.squareup.moshi.Json

 class MediumImageDto(

    @Json(name="width")
    val width: Int? = null,

    @Json(name="url")
    val url: String? = null,

    @Json(name="height")
    val height: Int? = null
)