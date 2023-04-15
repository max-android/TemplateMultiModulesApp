package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowExternalsDto(

	@Json(name="thetvdb")
	val thetvdb: Int? = null,

	@Json(name="imdb")
	val imdb: String? = null,

	@Json(name="tvrage")
	val tvrage: Int? = null
)