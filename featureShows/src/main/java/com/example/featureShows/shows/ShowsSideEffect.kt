package com.example.featureShows.shows

import com.example.common.BaseViewModel

sealed interface ShowsSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowShowsDetailEffect(val showId: String): ShowsSideEffect