package com.example.data.dto.beer

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class IngredientDto(
    @Json(name = "malt")
    val malt: List<MaltDto>? = null,
    @Json(name = "hops")
    val hops: List<MaltDto>? = null,
    @Json(name = "yeast")
    val yeast: String? = null,
)