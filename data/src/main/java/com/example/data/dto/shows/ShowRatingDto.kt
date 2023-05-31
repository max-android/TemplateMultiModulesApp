package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
class ShowRatingDto(

    @Json(name = "average")
    val average: Double? = null
)