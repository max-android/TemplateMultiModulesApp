package com.example.data.dto.openCollective

import com.squareup.moshi.Json

class MemberDto(
    @Json(name = "MemberId")
    val memberId: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "company")
    val company: String? = null,
    @Json(name = "role")
    val role: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "website")
    val website: String? = null,
    @Json(name = "lastTransactionAt")
    val lastTransactionAt: String? = null,
    @Json(name = "createdAt")
    val createdAt: String? = null,
)