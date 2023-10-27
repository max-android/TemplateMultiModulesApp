package com.example.data.dto.beer

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MaltDto(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "amount")
    val amount: AmountDto? = null,
)