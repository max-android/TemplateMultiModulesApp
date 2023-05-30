package com.example.data.dto.peoples.person

import com.squareup.moshi.Json

class PeopleDto(

	@Json(name="birthday")
	val birthday: String? = null,

	@Json(name="country")
	val countryPeopleDto: CountryPeopleDto? = null,

	@Json(name="image")
	val imagePeopleDto: ImagePeopleDto? = null,

	@Json(name="gender")
	val gender: String? = null,

	@Json(name="_links")
	val linksPeopleDto: LinksPeopleDto? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="updated")
	val updated: Int? = null,

	@Json(name="url")
	val url: String? = null
)