package com.example.data.dto.episodes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class EpisodesDto(

    @Json(name = "summary")
    val summary: String? = null,

    @Json(name = "image")
    val image: ImageEpisodesDto? = null,

    @Json(name = "airdate")
    val airdate: String? = null,

    @Json(name = "rating")
    val rating: RatingEpisodesDto? = null,

    @Json(name = "runtime")
    val runtime: Int? = null,

    @Json(name = "airstamp")
    val airstamp: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "number")
    val number: Int? = null,

    @Json(name = "airtime")
    val airtime: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "season")
    val season: Int? = null,

    @Json(name = "id")
    val id: Int? = null
)