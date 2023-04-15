package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowNetworkDto(

	@Json(name="showCountryDto")
	val showCountryDto: ShowCountryDto? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="officialSite")
	val officialSite: String? = null
)