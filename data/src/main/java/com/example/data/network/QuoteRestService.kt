package com.example.data.network

import com.example.data.dto.quote.QuoteDto
import retrofit2.Response
import retrofit2.http.GET

interface QuoteRestService {

    @GET("all")
    suspend fun allQuote(): Response<List<QuoteDto>>

    @GET("series")
    suspend fun seriesQuote(): Response<List<String>>

    @GET("colors")
    suspend fun colorsQuote(): Response<List<String>>


    //https://web-series-quotes-api.deta.dev/series
    //["breaking_bad","dark","game_of_thrones","money_heist"]

    //https://web-series-quotes-api.deta.dev/colors

   //["aliceblue","antiquewhite","aqua","aquamarine","azure"]


    // request with QUERY PARAMETERS
    //https://web-series-quotes-api.deta.dev/pic/custom

    //https://web-series-quotes-api.deta.dev/pic/image

    //https://web-series-quotes-api.deta.dev/pic/solid

    //https://web-series-quotes-api.deta.dev/redoc#tag/Get-Quotes-with-Image-backgroud
}