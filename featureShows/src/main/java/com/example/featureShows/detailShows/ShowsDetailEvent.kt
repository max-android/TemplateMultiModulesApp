package com.example.featureShows.detailShows

import com.example.common.BaseViewModel

sealed interface ShowsDetailEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowSiteShowsEvent(val url: String): ShowsDetailEvent