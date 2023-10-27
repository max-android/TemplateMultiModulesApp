package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.beer.BeerModel
import com.example.domain.repository.BeerRepository
import javax.inject.Inject

class BeerInteractor @Inject constructor(private val beerRepository: BeerRepository) {

    suspend fun allBeer(): ResultState<List<BeerModel>> {
        return try {
            val allBeer = beerRepository.allBeer()
            ResultState.Success(allBeer)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun detailBeer(id: String): ResultState<BeerModel> {
        return try {
            val detailBeer = beerRepository.detailBeer(id)
            ResultState.Success(detailBeer)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}