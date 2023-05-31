package com.example.data.dto.quote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class QuoteDto(

    @Json(name = "quote")
    val quote: String? = null,

    @Json(name = "author")
    val author: String? = null,

    @Json(name = "series")
    val series: String? = null,

    @Json(name = "id")
    val id: Int? = null
)