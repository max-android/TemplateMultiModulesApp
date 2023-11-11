package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel
import com.example.domain.repository.PlayersRepository
import javax.inject.Inject

class PlayersInteractor @Inject constructor(
    private val playersRepository: PlayersRepository
) {

    suspend fun players(): ResultState<List<PlayerModel>> {
        return try {
            val players = playersRepository.players()
            ResultState.Success(players)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun player(id: String): ResultState<PlayerModel> {
        return try {
            val player = playersRepository.player(id)
            ResultState.Success(player)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun teams(): ResultState<List<TeamModel>> {
        return try {
            val teams = playersRepository.teams()
            ResultState.Success(teams)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun team(id: String): ResultState<TeamModel> {
        return try {
            val team = playersRepository.team(id)
            ResultState.Success(team)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun games(): ResultState<List<GameModel>> {
        return try {
            val games = playersRepository.games()
            ResultState.Success(games)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun game(id: String): ResultState<GameModel> {
        return try {
            val game = playersRepository.game(id)
            ResultState.Success(game)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}