package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowImageDto(

	@Json(name="original")
	val original: String? = null,

	@Json(name="medium")
	val medium: String? = null
)