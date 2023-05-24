package com.example.data.network.old

import com.example.data.dto.NewsDto
import retrofit2.Response
import retrofit2.http.GET

interface NewsRestService {

    @GET("ARTICLES")
    suspend fun news(): Response<List<NewsDto>>

}