package com.example.data.dto.peoples.person

import com.squareup.moshi.Json

class LinksPeopleDto(

	@Json(name="self")
	val selfPeopleDto: SelfPeopleDto? = null
)