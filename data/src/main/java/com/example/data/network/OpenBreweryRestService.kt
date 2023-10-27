package com.example.data.network

import com.example.data.dto.brewery.BreweryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenBreweryRestService {

    //https://api.openbrewerydb.org/v1/breweries
    @GET("breweries")
    suspend fun breweries(): Response<List<BreweryDto>>

    //https://api.openbrewerydb.org/v1/breweries/search?query=Brewing
    @GET("breweries/search")
    suspend fun searchBreweries(@Query("query") search: String): Response<List<BreweryDto>>

}