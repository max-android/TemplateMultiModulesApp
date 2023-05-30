package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toEpisodeModel
import com.example.data.mapper.toListEpisodeModel
import com.example.data.mapper.toListGuestCastEpisodesModel
import com.example.data.mapper.toListGuestCrewEpisodesModel
import com.example.data.network.TvShowsRestService
import com.example.domain.model.episodes.EpisodesModel
import com.example.domain.model.episodes.GuestCastEpisodesModel
import com.example.domain.model.episodes.GuestCrewEpisodesModel
import com.example.domain.repository.EpisodesRepository

class EpisodesRepositoryImpl(
    private val tvShowsRestService: TvShowsRestService
) : EpisodesRepository {

    override suspend fun episodesShows(idShow: String): List<EpisodesModel> {
        return tvShowsRestService.episodesShows(idShow).handleBodyDto().toListEpisodeModel()
    }

    override suspend fun detailEpisode(idEpisode: String): EpisodesModel {
        return tvShowsRestService.detailEpisode(idEpisode).handleBodyDto().toEpisodeModel()
    }

    override suspend fun guestCastEpisode(idEpisode: String): List<GuestCastEpisodesModel> {
        return tvShowsRestService.guestCastEpisode(idEpisode).handleBodyDto()
            .toListGuestCastEpisodesModel()
    }

    override suspend fun guestCrewEpisode(idEpisode: String): List<GuestCrewEpisodesModel> {
        return tvShowsRestService.guestCrewEpisode(idEpisode).handleBodyDto()
            .toListGuestCrewEpisodesModel()
    }

}