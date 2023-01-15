package com.example.data.network

import com.example.data.dto.NewsDto
import retrofit2.Response
import retrofit2.http.GET

interface NewsRestService {

    //@GET("ARTICLES")
    @GET("A4234/354/456/dfgdfg")
    //suspend fun news(): Response<List<NewsDto>>
    suspend fun news(): Response<List<NewsDto>>

}