package com.example.data.dto.peoples.cast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PeopleCastCreditsDto(

    @Json(name = "voice")
    val voice: Boolean? = null,

    @Json(name = "_links")
    val links: LinksPersonCastCreditsDto? = null,

    @Json(name = "self")
    val self: Boolean? = null
)