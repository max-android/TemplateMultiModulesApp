package com.example.featureEpisodes.castEpisode

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.episodes.GuestCastEpisodesModel

sealed class EpisodeCastState: BaseViewModel.BaseViewState
@Immutable
data class EpisodeCastSuccess(val listCast: List<GuestCastEpisodesModel>): EpisodeCastState()
data object EpisodeCastLoading: EpisodeCastState()
data class EpisodeCastError(val exception: Throwable) : EpisodeCastState()