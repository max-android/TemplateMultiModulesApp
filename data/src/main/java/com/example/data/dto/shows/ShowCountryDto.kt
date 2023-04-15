package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowCountryDto(

	@Json(name="code")
	val code: String? = null,

	@Json(name="timezone")
	val timezone: String? = null,

	@Json(name="name")
	val name: String? = null
)