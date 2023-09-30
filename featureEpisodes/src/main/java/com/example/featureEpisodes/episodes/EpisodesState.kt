package com.example.featureEpisodes.episodes

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.episodes.EpisodesModel

sealed class EpisodesState : BaseViewModel.BaseViewState
@Immutable
data class EpisodesSuccess(
    val listEpisodes: List<EpisodesModel>
) : EpisodesState()
data object EpisodesEmpty : EpisodesState()
data object EpisodesLoading : EpisodesState()
data class EpisodesError(val exception: Throwable) : EpisodesState()