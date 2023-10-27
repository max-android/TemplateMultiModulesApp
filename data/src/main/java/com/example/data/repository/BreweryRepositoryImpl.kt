package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toListBreweryModel
import com.example.data.network.OpenBreweryRestService
import com.example.domain.model.brewery.BreweryModel
import com.example.domain.repository.BreweryRepository
import javax.inject.Inject

class BreweryRepositoryImpl @Inject constructor(
    private val openBreweryRestService: OpenBreweryRestService
) : BreweryRepository {

    override suspend fun breweries(): List<BreweryModel> {
        return openBreweryRestService.breweries().handleBodyDto().toListBreweryModel()
    }

    override suspend fun searchBreweries(search: String): List<BreweryModel> {
        return openBreweryRestService.searchBreweries(search).handleBodyDto().toListBreweryModel()
    }

}