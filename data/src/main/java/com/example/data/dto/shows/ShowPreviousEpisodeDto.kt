package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowPreviousEpisodeDto(

	@Json(name="href")
	val href: String? = null
)