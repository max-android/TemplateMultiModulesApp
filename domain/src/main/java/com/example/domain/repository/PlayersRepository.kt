package com.example.domain.repository

import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel

interface PlayersRepository {

    suspend fun players(): List<PlayerModel>

    suspend fun player(id: String): PlayerModel

    suspend fun teams(): List<TeamModel>

    suspend fun team(id: String): TeamModel

    suspend fun games(): List<GameModel>

    suspend fun game(id: String): GameModel

}