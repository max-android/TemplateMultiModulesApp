package com.example.data.dto.shows

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
 class ShowDto(

	@Json(name="summary")
	val summary: String? = null,

	@Json(name="image")
	val showImageDto: ShowImageDto? = null,

	@Json(name="averageRuntime")
	val averageRuntime: Int? = null,

	@Json(name="_links")
	val showLinksDto: ShowLinksDto? = null,

	@Json(name="premiered")
	val premiered: String? = null,

	@Json(name="showRatingDto")
	val showRatingDto: ShowRatingDto? = null,

	@Json(name="runtime")
	val runtime: Int? = null,

	@Json(name="weight")
	val weight: Int? = null,

	@Json(name="language")
	val language: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="officialSite")
	val officialSite: String? = null,

	@Json(name="showNetworkDto")
	val showNetworkDto: ShowNetworkDto? = null,

	@Json(name="showScheduleDto")
	val showScheduleDto: ShowScheduleDto? = null,

	@Json(name="genres")
	val genres: List<String?>? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="ended")
	val ended: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="showExternalsDto")
	val showExternalsDto: ShowExternalsDto? = null,

	@Json(name="updated")
	val updated: Int? = null,

	@Json(name="status")
	val status: String? = null
)