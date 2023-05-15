package com.example.featureShows.shows

import com.example.common.BaseViewModel
import com.example.domain.model.shows.ListShowsModel

sealed class ShowsState: BaseViewModel.BaseViewState
data class ShowsListSuccess(val listShows: List<ListShowsModel>): ShowsState()
object ShowsListEmpty: ShowsState()
object ShowsListLoading: ShowsState()
data class ShowsListError(val exception: Throwable): ShowsState()