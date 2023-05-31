package com.example.data.dto.peoples.person

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ImagePeopleDto(

	@Json(name="original")
	val original: String? = null,

	@Json(name="medium")
	val medium: String? = null
)