package com.example.data.dto.shows.seasons

import com.squareup.moshi.Json

 class SeasonsDto(

     @Json(name="summary")
    val summary: String? = null,

     @Json(name="number")
    val number: Int? = null,

     @Json(name="image")
    val image: SeasonsImageDto? = null,

     @Json(name="premiereDate")
    val premiereDate: String? = null,

     @Json(name="endDate")
    val endDate: String? = null,

     @Json(name="webChannel")
    val webChannel: String? = null,

     @Json(name="name")
    val name: String? = null,

     @Json(name="episodeOrder")
    val episodeOrder: Int? = null,

     @Json(name="id")
    val id: Int? = null,

     @Json(name="url")
    val url: String? = null,

     @Json(name="network")
    val network: SeasonsNetworkDto? = null
)