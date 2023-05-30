package com.example.data.dto.peoples.person

import com.squareup.moshi.Json

class SearchPeopleDto(@Json(name = "person") val person: PeopleDto? = null)