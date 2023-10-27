package com.example.domain.repository

import com.example.domain.model.brewery.BreweryModel

interface BreweryRepository {

    suspend fun breweries(): List<BreweryModel>

    suspend fun searchBreweries(search: String): List<BreweryModel>
}