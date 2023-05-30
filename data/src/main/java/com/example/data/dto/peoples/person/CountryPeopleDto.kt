package com.example.data.dto.peoples.person

import com.squareup.moshi.Json

class CountryPeopleDto(

	@Json(name="code")
	val code: String? = null,

	@Json(name="timezone")
	val timezone: String? = null,

	@Json(name="name")
	val name: String? = null
)