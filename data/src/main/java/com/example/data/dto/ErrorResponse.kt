package com.example.data.dto

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "code")
    val code: Int? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "status")
    val status: Int? = null
)
