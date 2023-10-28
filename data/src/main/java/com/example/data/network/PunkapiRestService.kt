package com.example.data.network

import com.example.data.dto.beer.BeerItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PunkapiRestService {

    //https://api.punkapi.com/v2/beers
    @GET("beers")
    @Headers("Content-Type: application/json")
    suspend fun allBeer(): Response<List<BeerItemDto>>

    //https://api.punkapi.com/v2/beers/1
    @GET("beers/{id}")
    //@Headers("Content-Type: application/json")
    suspend fun detailBeer(@Path("id") id: String): Response<List<BeerItemDto>>
}