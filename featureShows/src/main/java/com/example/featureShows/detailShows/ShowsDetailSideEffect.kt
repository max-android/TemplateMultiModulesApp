package com.example.featureShows.detailShows

import com.example.common.BaseViewModel

sealed interface ShowsDetailSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowSiteShowsEffect(val url: String): ShowsDetailSideEffect