package com.example.featureShows.detailShows

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.shows.ShowModel

sealed class ShowsDetailState: BaseViewModel.BaseViewState
object ShowsDetailLoading: ShowsDetailState()
@Immutable
data class ShowsDetailSuccess(val showModel: ShowModel): ShowsDetailState()
data class ShowsDetailError(val exception: Throwable): ShowsDetailState()
