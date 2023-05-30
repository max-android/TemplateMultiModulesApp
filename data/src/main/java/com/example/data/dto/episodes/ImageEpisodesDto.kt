package com.example.data.dto.episodes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 class ImageEpisodesDto(

	@Json(name="original")
	val original: String? = null,

	@Json(name="medium")
	val medium: String? = null
)