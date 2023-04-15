package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.repository.ShowsRepository
import javax.inject.Inject

class ShowsInteractor @Inject constructor(
    private val showsRepository: ShowsRepository
) {

    suspend fun allShows(): ResultState<List<ListShowsModel>> {
        return try {
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

}