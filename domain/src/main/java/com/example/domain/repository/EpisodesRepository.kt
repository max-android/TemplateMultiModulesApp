package com.example.domain.repository

import com.example.domain.model.episodes.EpisodesModel
import com.example.domain.model.episodes.GuestCastEpisodesModel
import com.example.domain.model.episodes.GuestCrewEpisodesModel

interface EpisodesRepository {

    suspend fun episodesShows(idShow: String): List<EpisodesModel>

    suspend fun detailEpisode(idEpisode: String): EpisodesModel

    suspend fun guestCastEpisode(idEpisode: String): List<GuestCastEpisodesModel>

    suspend fun guestCrewEpisode(idEpisode: String): List<GuestCrewEpisodesModel>
}