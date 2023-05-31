package com.example.data.dto.peoples.cast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 class CharacterPersonCastCreditsDto(

	@Json(name="href")
	val href: String? = null
)