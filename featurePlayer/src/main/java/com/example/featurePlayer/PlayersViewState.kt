package com.example.featurePlayer

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel

sealed class PlayersViewState : BaseViewModel.BaseViewState
@Immutable
data class PlayersListSuccess(
    val players: List<PlayerModel>,
    val teams: List<TeamModel>,
    val games: List<GameModel>,
) : PlayersViewState()
data object PlayersListLoading : PlayersViewState()
data class PlayersListError(val exception: Throwable) : PlayersViewState()