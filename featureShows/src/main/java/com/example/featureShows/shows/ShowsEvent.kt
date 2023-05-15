package com.example.featureShows.shows

import com.example.common.BaseViewModel

sealed interface ShowsEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowsDetailEvent(val showsId: String): ShowsEvent


