package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
class ShowScheduleDto(

    @Json(name = "days")
    val days: List<String?>? = null,

    @Json(name = "time")
    val time: String? = null
)