package com.example.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "summary")
    val summary: String,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "url")
    val webUrl: String,
    @Json(name = "newsSite")
    val newsSite: String,
    @Json(name = "publishedAt")
    val publishedAt: String,
)