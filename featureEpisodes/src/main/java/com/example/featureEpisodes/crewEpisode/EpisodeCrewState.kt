package com.example.featureEpisodes.crewEpisode

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.episodes.GuestCrewEpisodesModel

sealed class EpisodeCrewState : BaseViewModel.BaseViewState
@Immutable
data class EpisodeCrewSuccess(val listCrew: List<GuestCrewEpisodesModel>): EpisodeCrewState()
data object EpisodeCrewLoading: EpisodeCrewState()
data class EpisodeCrewError(val exception: Throwable) : EpisodeCrewState()