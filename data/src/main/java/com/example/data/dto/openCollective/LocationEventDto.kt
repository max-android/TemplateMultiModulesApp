package com.example.data.dto.openCollective

import com.squareup.moshi.Json

 class LocationEventDto(

    @Json(name="address")
    val address: String? = null,

    @Json(name="name")
    val name: String? = null,

    @Json(name="lat")
    val lat: Double? = null,

    @Json(name="long")
    val jsonMemberLong: Double? = null
)