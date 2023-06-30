package com.example.domain.interactor

import android.util.Log
import com.example.domain.common.ResultState
import com.example.domain.model.shows.CrewModel
import com.example.domain.model.shows.seasons.SeasonsModel
import com.example.domain.model.shows.CastModel
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.model.shows.ShowsImageModel
import com.example.domain.repository.ShowsRepository
import javax.inject.Inject

class ShowsInteractor @Inject constructor(
    private val showsRepository: ShowsRepository
) {

    suspend fun allShows(): ResultState<List<ListShowsModel>> {
        return try {
            Log.i("--STATE", "-------------ShowsComponent request()")
            val shows = showsRepository.allShows()
            ResultState.Success(shows)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun detailShow(idShow: String): ResultState<ShowModel> {
        return try {
            val show = showsRepository.detailShow(idShow)
            ResultState.Success(show)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun seasonsShows(idShow: String): ResultState<List<SeasonsModel>> {
        return try {
            val seasonsShows = showsRepository.seasonsShows(idShow)
            ResultState.Success(seasonsShows)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun crewShows(idShow: String): ResultState<List<CrewModel>> {
        return try {
            val crewShows = showsRepository.crewShows(idShow)
            ResultState.Success(crewShows)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun castShows(idShow: String): ResultState<List<CastModel>> {
        return try {
            val castShows = showsRepository.castShows(idShow)
            ResultState.Success(castShows)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun imagesShows(idShow: String): ResultState<List<ShowsImageModel>> {
        return try {
            val imagesShows = showsRepository.imagesShows(idShow)
            ResultState.Success(imagesShows)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun searchShows(search: String): ResultState<List<ListShowsModel>> {
        return try {
            val shows = showsRepository.searchShows(search)
            ResultState.Success(shows)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}