package com.example.data.dto.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsDto(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "author")
    val author: String? = null,
    @Json(name = "date")
    val date: String? = null,
    @Json(name = "imageUrl")
    val imageUrl: String? = null,
    @Json(name = "readMoreUrl")
    val readMoreUrl: String? = null,
    @Json(name = "content")
    val content: String? = null,
)