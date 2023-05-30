package com.example.data.dto.peoples.cast

import com.squareup.moshi.Json

 class LinksPersonCastCreditsDto(

	 @Json(name="character")
	val character: CharacterPersonCastCreditsDto? = null,

	 @Json(name="show")
	val show: ShowPersonCastCreditsDto? = null
)