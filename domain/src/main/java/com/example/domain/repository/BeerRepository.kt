package com.example.domain.repository

import com.example.domain.model.beer.BeerModel

interface BeerRepository {

    suspend fun allBeer(): List<BeerModel>

    suspend fun detailBeer(id: String): BeerModel

}