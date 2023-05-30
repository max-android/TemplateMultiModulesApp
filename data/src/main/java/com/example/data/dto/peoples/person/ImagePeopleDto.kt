package com.example.data.dto.peoples.person

import com.squareup.moshi.Json

class ImagePeopleDto(

	@Json(name="original")
	val original: String? = null,

	@Json(name="medium")
	val medium: String? = null
)