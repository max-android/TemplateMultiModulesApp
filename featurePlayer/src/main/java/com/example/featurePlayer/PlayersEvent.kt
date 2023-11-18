package com.example.featurePlayer

import com.example.common.BaseViewModel

sealed interface PlayersEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowPlayerDetailEvent(val playerId: String): PlayersEvent
@JvmInline
value class ShowTeamDetailEvent(val teamId: String): PlayersEvent
@JvmInline
value class ShowGameDetailEvent(val gameId: String): PlayersEvent