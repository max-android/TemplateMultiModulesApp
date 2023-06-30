package com.example.featureShows.shows

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.common.EMPTY_VALUE
import com.example.domain.model.shows.ListShowsModel

sealed class ShowsState : BaseViewModel.BaseViewState
@Immutable
data class ShowsListSuccess(
    val listShows: List<ListShowsModel>,
    val search: String = EMPTY_VALUE
) : ShowsState()

object ShowsListEmpty : ShowsState()
object ShowsListLoading : ShowsState()
data class ShowsListError(val exception: Throwable) : ShowsState()