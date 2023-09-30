package com.example.featureEpisodes.detailEpisodes

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.episodes.EpisodesModel

sealed class EpisodeDetailState: BaseViewModel.BaseViewState
data object EpisodeDetailLoading: EpisodeDetailState()
@Immutable
data class EpisodeDetailSuccess(val episodesModel: EpisodesModel): EpisodeDetailState()
data class EpisodeDetailError(val exception: Throwable): EpisodeDetailState()