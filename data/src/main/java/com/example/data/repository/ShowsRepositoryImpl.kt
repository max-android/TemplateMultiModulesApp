package com.example.data.repository

import com.example.data.common.handleBodyDto2
import com.example.data.mapper.toListShowModel
import com.example.data.mapper.toShowModel
import com.example.data.network.ShowsRestService
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.repository.ShowsRepository
import javax.inject.Inject

class ShowsRepositoryImpl @Inject constructor(
    private val showsRestService: ShowsRestService
) : ShowsRepository {

    override suspend fun allShows(): List<ListShowsModel> {
       return showsRestService.allShows().handleBodyDto2().toListShowModel()
    }

    override suspend fun detailShow(idShow: String): ShowModel {
        return showsRestService.detailShow(idShow).handleBodyDto2().toShowModel()
    }
}