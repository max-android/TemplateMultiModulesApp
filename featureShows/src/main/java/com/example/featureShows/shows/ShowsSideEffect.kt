package com.example.featureShows.shows

import com.example.common.BaseViewModel

sealed interface ShowsSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowShowsDetailEffect(val showId: String): ShowsSideEffect
@JvmInline
value class ShowShowsSeasonsEffect(val showId: String): ShowsSideEffect
@JvmInline
value class ShowShowsCastEffect(val showId: String): ShowsSideEffect
@JvmInline
value class ShowShowsCrewEffect(val showId: String): ShowsSideEffect