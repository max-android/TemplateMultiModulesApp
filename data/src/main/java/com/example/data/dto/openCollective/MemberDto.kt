package com.example.data.dto.openCollective

import com.squareup.moshi.Json

class MemberDto(

    @Json(name = "image")
    val image: String? = null,

    @Json(name = "github")
    val github: String? = null,

    @Json(name = "website")
    val website: String? = null,

    @Json(name = "role")
    val role: String? = null,

    @Json(name = "lastTransactionAmount")
    val lastTransactionAmount: Int? = null,

    @Json(name = "profile")
    val profile: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "isActive")
    val isActive: Boolean? = null,

    @Json(name = "lastTransactionAt")
    val lastTransactionAt: String? = null,

    @Json(name = "MemberId")
    val memberId: Int? = null,

    @Json(name = "createdAt")
    val createdAt: String? = null,

    @Json(name = "tier")
    val tier: String? = null,

    @Json(name = "totalAmountDonated")
    val totalAmountDonated: Int? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "currency")
    val currency: String? = null,

    @Json(name = "company")
    val company: String? = null,

    @Json(name = "email")
    val email: String? = null,
)