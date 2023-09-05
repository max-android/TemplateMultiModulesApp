package com.example.featureSeasons

import com.example.common.BaseViewModel

sealed interface ShowsSeasonsSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowSiteSeasonsEffect(val url: String): ShowsSeasonsSideEffect