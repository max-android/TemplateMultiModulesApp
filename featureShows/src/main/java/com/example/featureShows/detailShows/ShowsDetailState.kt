package com.example.featureShows.detailShows

import com.example.common.BaseViewModel
import com.example.domain.model.shows.ShowModel

sealed class ShowsDetailState: BaseViewModel.BaseViewState
object ShowsDetailLoading: ShowsDetailState()
data class ShowsDetailSuccess(val showModel: ShowModel): ShowsDetailState()
data class ShowsDetailError(val exception: Throwable): ShowsDetailState()
