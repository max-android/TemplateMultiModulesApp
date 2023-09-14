package com.example.featureShows.castShows

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.shows.CastModel


sealed class ShowsCastState: BaseViewModel.BaseViewState
@Immutable
data class ShowsCastSuccess(val listCrew: List<CastModel>): ShowsCastState()
object ShowsCastLoading: ShowsCastState()
data class ShowsCastError(val exception: Throwable) : ShowsCastState()