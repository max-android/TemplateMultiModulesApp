package com.example.data.dto.peoples.person

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LinksPeopleDto(

	@Json(name="self")
	val selfPeopleDto: SelfPeopleDto? = null
)