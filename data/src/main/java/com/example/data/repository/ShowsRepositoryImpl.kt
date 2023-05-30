package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toListCastModel
import com.example.data.mapper.toListCrewModel
import com.example.data.mapper.toListSearchShowsModel
import com.example.data.mapper.toListSeasonsModel
import com.example.data.mapper.toListShowModel
import com.example.data.mapper.toListShowsImageModel
import com.example.data.mapper.toShowModel
import com.example.data.network.TvShowsRestService
import com.example.domain.model.shows.CrewModel
import com.example.domain.model.shows.seasons.SeasonsModel
import com.example.domain.model.shows.CastModel
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.model.shows.ShowsImageModel
import com.example.domain.repository.ShowsRepository
import javax.inject.Inject

class ShowsRepositoryImpl @Inject constructor(
    private val tvShowsRestService: TvShowsRestService
) : ShowsRepository {

    override suspend fun allShows(): List<ListShowsModel> {
       return tvShowsRestService.allShows().handleBodyDto().toListShowModel()
    }

    override suspend fun detailShow(idShow: String): ShowModel {
        return tvShowsRestService.detailShow(idShow).handleBodyDto().toShowModel()
    }

    override suspend fun seasonsShows(idShow: String): List<SeasonsModel> {
        return tvShowsRestService.seasonsShows(idShow).handleBodyDto().toListSeasonsModel()
    }

    override suspend fun crewShows(idShow: String): List<CrewModel> {
        return tvShowsRestService.crewShows(idShow).handleBodyDto().toListCrewModel()
    }

    override suspend fun castShows(idShow: String): List<CastModel> {
        return tvShowsRestService.castShows(idShow).handleBodyDto().toListCastModel()
    }

    override suspend fun imagesShows(idShow: String): List<ShowsImageModel> {
        return tvShowsRestService.imagesShows(idShow).handleBodyDto().toListShowsImageModel()
    }

    override suspend fun searchShows(shows: String): List<ShowModel> {
        return tvShowsRestService.searchShows(shows).handleBodyDto().toListSearchShowsModel()
    }

}