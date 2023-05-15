package com.example.featureShows.shows

import com.example.common.BaseViewModel

sealed interface ShowsSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowsDetailEffect(val showId: String): ShowsSideEffect