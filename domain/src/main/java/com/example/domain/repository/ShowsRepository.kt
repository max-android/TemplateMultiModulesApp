package com.example.domain.repository

import com.example.domain.model.shows.CrewModel
import com.example.domain.model.shows.seasons.SeasonsModel
import com.example.domain.model.shows.CastModel
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.model.shows.ShowsImageModel

interface ShowsRepository {

    suspend fun allShows(): List<ListShowsModel>

    suspend fun detailShow(idShow: String): ShowModel

    suspend fun seasonsShows(idShow: String): List<SeasonsModel>

    suspend fun crewShows(idShow: String): List<CrewModel>
    suspend fun castShows(idShow: String): List<CastModel>

    suspend fun imagesShows(idShow: String): List<ShowsImageModel>

    suspend fun searchShows(shows: String): List<ListShowsModel>

}