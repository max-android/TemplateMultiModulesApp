package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toGameModel
import com.example.data.mapper.toListGameModel
import com.example.data.mapper.toListPlayerModel
import com.example.data.mapper.toListTeamModel
import com.example.data.mapper.toPlayerModel
import com.example.data.mapper.toTeamModel
import com.example.data.network.PlayersRestService
import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel
import com.example.domain.repository.PlayersRepository
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(
    private val playersRestService: PlayersRestService
) : PlayersRepository {

    override suspend fun players(): List<PlayerModel> {
        return playersRestService.players().handleBodyDto().toListPlayerModel()
    }

    override suspend fun player(id: String): PlayerModel {
        return toPlayerModel(playersRestService.player(id).handleBodyDto())
    }

    override suspend fun teams(): List<TeamModel> {
        return playersRestService.teams().handleBodyDto().toListTeamModel()
    }

    override suspend fun team(id: String): TeamModel {
        return toTeamModel(playersRestService.team(id).handleBodyDto())
    }

    override suspend fun games(): List<GameModel> {
        return playersRestService.games().handleBodyDto().toListGameModel()
    }

    override suspend fun game(id: String): GameModel {
       return toGameModel(playersRestService.game(id).handleBodyDto())
    }

}