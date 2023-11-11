package com.example.data.mapper

import com.example.common.int
import com.example.data.dto.players.GameDto
import com.example.data.dto.players.GamesDto
import com.example.data.dto.players.PlayerDto
import com.example.data.dto.players.PlayersDto
import com.example.data.dto.players.TeamDto
import com.example.data.dto.players.TeamsDto
import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel

fun PlayersDto?.toListPlayerModel(): List<PlayerModel> {
    return this?.data?.map(::toPlayerModel) ?: emptyList()
}

fun toPlayerModel(playerDto: PlayerDto?): PlayerModel {
    return PlayerModel(
        id = playerDto?.id.int(),
        firstName = playerDto?.firstName.orEmpty(),
        lastName = playerDto?.lastName.orEmpty(),
        position = playerDto?.position.orEmpty(),
        heightFeet = playerDto?.heightFeet.int(),
        heightInches = playerDto?.heightInches.int(),
        weightPounds = playerDto?.weightPounds.int()
    )
}

fun TeamsDto?.toListTeamModel(): List<TeamModel> {
    return this?.data?.map(::toTeamModel) ?: emptyList()
}

fun toTeamModel(teamDto: TeamDto?): TeamModel {
    return TeamModel(
        id = teamDto?.id.int(),
        abbreviation = teamDto?.abbreviation.orEmpty(),
        city = teamDto?.city.orEmpty(),
        conference = teamDto?.conference.orEmpty(),
        division = teamDto?.division.orEmpty(),
        fullName = teamDto?.fullName.orEmpty()
    )
}

fun GamesDto?.toListGameModel(): List<GameModel> {
    return this?.data?.map(::toGameModel) ?: emptyList()
}

fun toGameModel(gameDto: GameDto?): GameModel {
    return GameModel(
        id = gameDto?.id.int(),
        date = gameDto?.date.orEmpty(),
        homeTeamScore = gameDto?.homeTeamScore.int(),
        visitorTeamScore = gameDto?.visitorTeamScore.int(),
        season = gameDto?.season.int(),
        period = gameDto?.period.int(),
        status = gameDto?.status.orEmpty(),
        homeTeam = toTeamModel(gameDto?.homeTeam),
        visitorTeam = toTeamModel(gameDto?.visitorTeam)
    )
}