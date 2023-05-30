package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.episodes.EpisodesModel
import com.example.domain.model.episodes.GuestCastEpisodesModel
import com.example.domain.model.episodes.GuestCrewEpisodesModel
import com.example.domain.repository.EpisodesRepository
import javax.inject.Inject

class EpisodesInteractor @Inject constructor(
    private val episodesRepository: EpisodesRepository
) {

    suspend fun episodesShows(idShow: String): ResultState<List<EpisodesModel>> {
        return try {
            val episodes = episodesRepository.episodesShows(idShow)
            ResultState.Success(episodes)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun detailEpisode(idEpisode: String): ResultState<EpisodesModel> {
        return try {
            val episode = episodesRepository.detailEpisode(idEpisode)
            ResultState.Success(episode)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun guestCastEpisode(idEpisode: String): ResultState<List<GuestCastEpisodesModel>> {
        return try {
            val guestCastEpisode = episodesRepository.guestCastEpisode(idEpisode)
            ResultState.Success(guestCastEpisode)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun guestCrewEpisode(idEpisode: String): ResultState<List<GuestCrewEpisodesModel>> {
        return try {
            val guestCrewEpisode = episodesRepository.guestCrewEpisode(idEpisode)
            ResultState.Success(guestCrewEpisode)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}