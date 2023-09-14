package com.example.featureShows.crewShows

import com.example.common.BaseViewModel

sealed interface ShowsCrewEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowsSiteCrewEvent(val url: String): ShowsCrewEvent