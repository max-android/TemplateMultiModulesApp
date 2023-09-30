package com.example.featureEpisodes.episodes

import com.example.common.BaseViewModel

sealed interface EpisodesSideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class ShowEpisodeDetailEffect(val episodeId: String): EpisodesSideEffect
@JvmInline
value class ShowEpisodesCastEffect(val episodeId: String): EpisodesSideEffect
@JvmInline
value class ShowEpisodesCrewEffect(val episodeId: String): EpisodesSideEffect