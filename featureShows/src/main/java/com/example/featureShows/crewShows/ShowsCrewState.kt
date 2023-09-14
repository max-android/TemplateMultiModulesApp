package com.example.featureShows.crewShows

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.shows.CrewModel

sealed class ShowsCrewState : BaseViewModel.BaseViewState
@Immutable
data class ShowsCrewSuccess(val listCrew: List<CrewModel>): ShowsCrewState()
object ShowsCrewLoading: ShowsCrewState()
data class ShowsCrewError(val exception: Throwable) : ShowsCrewState()