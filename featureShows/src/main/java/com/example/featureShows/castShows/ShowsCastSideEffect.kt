package com.example.featureShows.castShows

import com.example.common.BaseViewModel

sealed interface ShowsCastSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowsSiteCastEffect(val url: String): ShowsCastSideEffect