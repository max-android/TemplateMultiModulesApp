package com.example.data.dto.beer

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BeerItemDto(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "tagline")
    val tagline: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null,
    @Json(name = "volume")
    val volume: AmountDto? = null,
    @Json(name = "brewers_tips")
    val tips: String? = null,
    @Json(name = "food_pairing")
    val food: List<String>? = null,
    @Json(name = "ingredients")
    val ingredient: IngredientDto? = null,
)