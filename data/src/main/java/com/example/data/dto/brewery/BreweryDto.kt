package com.example.data.dto.brewery

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BreweryDto(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "city")
    val city: String? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "longitude")
    val longitude: String? = null,
    @Json(name = "latitude")
    val latitude: String? = null,
    @Json(name = "phone")
    val phone: String? = null,
    @Json(name = "website_url")
    val site: String? = null,
    @Json(name = "state")
    val state: String? = null,
    @Json(name = "street")
    val street: String? = null,
)