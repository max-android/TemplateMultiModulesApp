package com.example.featureShows.shows

import com.example.common.BaseViewModel

sealed interface ShowsEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowShowsDetailEvent(val showsId: String): ShowsEvent
@JvmInline
value class ShowShowsSeasonsEvent(val showsId: String): ShowsEvent
@JvmInline
value class ShowShowsCastEvent(val showsId: String): ShowsEvent
@JvmInline
value class ShowShowsCrewEvent(val showsId: String): ShowsEvent
@JvmInline
value class ShowSearchEvent(val search: String): ShowsEvent


