package com.example.data.dto.episodes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 class RatingEpisodesDto(

	@Json(name="average")
	val average: Double? = null
)