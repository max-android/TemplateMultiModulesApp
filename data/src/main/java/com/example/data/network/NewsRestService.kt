package com.example.data.network

import com.example.data.dto.news.AllNewsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRestService {

    //https://inshorts.deta.dev/news?category=sports
    @GET("news")
    suspend fun news(@Query("category")category: String): Response<AllNewsDto>

    suspend fun categories(): List<String> = listOf(
        "all", "national", "business", "sports", "world", "politics", "technology", "startup",
        "entertainment", "miscellaneous", "hatke", "science", "automobile"
    )

}