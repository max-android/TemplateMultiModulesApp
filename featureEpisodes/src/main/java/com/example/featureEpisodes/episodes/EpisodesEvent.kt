package com.example.featureEpisodes.episodes

import com.example.common.BaseViewModel

sealed interface EpisodesEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowEpisodeDetailEvent(val episodesId: String): EpisodesEvent
@JvmInline
value class ShowEpisodeCastEvent(val episodesId: String): EpisodesEvent
@JvmInline
value class ShowEpisodeCrewEvent(val episodesId: String): EpisodesEvent