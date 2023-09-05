package com.example.featureSeasons

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.shows.seasons.SeasonsModel

sealed class ShowsSeasonsState : BaseViewModel.BaseViewState
@Immutable
data class ShowsSeasonsSuccess(val listSeasons: List<SeasonsModel>): ShowsSeasonsState()
object ShowsSeasonsEmpty: ShowsSeasonsState()
object ShowsSeasonsLoading: ShowsSeasonsState()
data class ShowsSeasonsError(val exception: Throwable) : ShowsSeasonsState()