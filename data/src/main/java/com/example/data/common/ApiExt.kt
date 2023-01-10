package com.example.data.common

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun <T> createRestService(
    moshiConverterFactory: MoshiConverterFactory,
    okHttpClient: OkHttpClient,
    baseUrl: String,
    service: Class<T>
): T {
    return Retrofit.Builder().apply {
        baseUrl(baseUrl)
        addConverterFactory(moshiConverterFactory)
        client(okHttpClient)
    }.build().create(service)
}