package com.example.data.dto.shows.image

import com.squareup.moshi.Json

class ResolutionsImageDto(

    @Json(name = "original")
    val original: OriginalImageDto? = null,

    @Json(name = "medium")
    val medium: MediumImageDto? = null
)