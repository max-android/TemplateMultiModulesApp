package com.example.featurePlayer

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.PlayersInteractor
import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val playersInteractor: PlayersInteractor
) : BaseViewModel() {

    init {
        loadData()
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

    private fun loadData() {
        viewModelScope.launch {
            val playersDeferred = async { playersInteractor.players() }
            val teamsDeferred = async { playersInteractor.teams() }
            val gamesDeferred = async { playersInteractor.games() }
            val players: ResultState<List<PlayerModel>> = playersDeferred.await()
            val teams: ResultState<List<TeamModel>> = teamsDeferred.await()
            val games: ResultState<List<GameModel>> = gamesDeferred.await()
            if (players is ResultState.Success && teams is ResultState.Success && games is ResultState.Success) {
                sendState(PlayersListSuccess(players.data, teams.data, games.data))
            } else {
                sendState(PlayersListError(Exception()))
            }
        }
    }


}