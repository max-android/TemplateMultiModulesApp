package com.example.featureSeasons

import com.example.common.BaseViewModel

sealed interface ShowsSeasonsEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowSiteSeasonsEvent(val url: String): ShowsSeasonsEvent