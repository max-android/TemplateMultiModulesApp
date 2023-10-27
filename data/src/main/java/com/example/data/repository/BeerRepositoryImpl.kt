package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toListBeerModel
import com.example.data.network.PunkapiRestService
import com.example.domain.model.beer.BeerModel
import com.example.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(
    private val punkapiRestService: PunkapiRestService
) : BeerRepository {

    override suspend fun allBeer(): List<BeerModel> {
        return punkapiRestService.allBeer().handleBodyDto().toListBeerModel()
    }

    override suspend fun detailBeer(id: String): BeerModel {
        return punkapiRestService.detailBeer(id).handleBodyDto().toListBeerModel().first()
    }

}