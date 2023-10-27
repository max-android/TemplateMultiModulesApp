package com.example.data.dto.beer

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AmountDto(
    @Json(name = "value")
    val value: Double? = null,
    @Json(name = "unit")
    val unit: String? = null,
)