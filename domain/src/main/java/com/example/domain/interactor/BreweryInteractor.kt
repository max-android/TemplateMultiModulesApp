package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.brewery.BreweryModel
import com.example.domain.repository.BreweryRepository
import javax.inject.Inject

class BreweryInteractor @Inject constructor(private val breweryRepository: BreweryRepository) {

    suspend fun breweries(): ResultState<List<BreweryModel>> {
        return try {
            val breweries = breweryRepository.breweries()
            ResultState.Success(breweries)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun searchBreweries(search: String): ResultState<List<BreweryModel>> {
        return try {
            val searchBreweries = breweryRepository.searchBreweries(search)
            ResultState.Success(searchBreweries)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}