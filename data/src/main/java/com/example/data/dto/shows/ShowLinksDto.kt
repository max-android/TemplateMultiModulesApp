package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowLinksDto(

	@Json(name="showSelfDto")
	val showSelfDto: ShowSelfDto? = null,

	@Json(name="showPreviousEpisodeDto")
	val showPreviousEpisodeDto: ShowPreviousEpisodeDto? = null
)