package com.example.featureShows.crewShows

import com.example.common.BaseViewModel

sealed interface ShowsCrewSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowsSiteCrewEffect(val url: String): ShowsCrewSideEffect