package com.example.featureShows.castShows

import com.example.common.BaseViewModel

sealed interface ShowsCastEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowsSiteCastEvent(val url: String): ShowsCastEvent