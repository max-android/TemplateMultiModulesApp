package com.example.featurePlayer

import com.example.common.BaseViewModel

sealed interface PlayersSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class PlayerDetailEffect(val showId: String): PlayersSideEffect
@JvmInline
value class TeamDetailEffect(val showId: String): PlayersSideEffect
@JvmInline
value class GameDetailEffect(val showId: String): PlayersSideEffect