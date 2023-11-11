package com.example.domain.model.players

class GameModel(
    val id: Int,
    val date: String,
    val homeTeamScore: Int,
    val visitorTeamScore: Int,
    val season: Int,
    val period: Int,
    val status: String,
    val homeTeam: TeamModel,
    val visitorTeam: TeamModel
)