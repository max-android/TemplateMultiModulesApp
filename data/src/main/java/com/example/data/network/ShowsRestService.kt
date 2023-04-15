package com.example.data.network

import com.example.data.dto.shows.ShowDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShowsRestService {

    @GET("shows")
    suspend fun allShows(): Response<List<ShowDto>>

    @GET("shows/{id}")
    suspend fun detailShow(@Path("id") id: String): Response<ShowDto>

}