package com.example.domain.repository

import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel

interface ShowsRepository {

    suspend fun allShows(): List<ListShowsModel>

    suspend fun detailShow(idShow: String): ShowModel

}