package com.example.data.dto

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "message")
    val message: String,
    @Json(name = "status")
    val status: Int
)
