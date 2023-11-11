package com.example.data.dto.players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GameDto(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "date")
    val date: String? = null,
    @Json(name = "home_team_score")
    val homeTeamScore: Int? = null,
    @Json(name = "visitor_team_score")
    val visitorTeamScore: Int? = null,
    @Json(name = "season")
    val season: Int? = null,
    @Json(name = "period")
    val period: Int? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "home_team")
    val homeTeam: TeamDto?,
    @Json(name = "visitor_team")
    val visitorTeam: TeamDto?
)