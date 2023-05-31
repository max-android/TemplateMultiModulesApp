package com.example.data.dto.peoples.person

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SearchPeopleDto(@Json(name = "person") val person: PeopleDto? = null)