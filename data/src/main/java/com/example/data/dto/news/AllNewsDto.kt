package com.example.data.dto.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AllNewsDto(
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "data")
    val data: List<NewsDto>? = null
)