package com.example.data.common

import android.util.Log
import com.example.common.*
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection

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

//TODO вариант 1
fun <T : Any> Response<T>.handleBodyDto(): ApiResult<T> {
    return try {
        val body = this.body()
        if (this.isSuccessful && body != null) {
            Log.i("--STATE", "-----------27")
            ApiSuccess(body)
        } else {
            Log.i("--STATE", "-----------30")
            ApiError(code = this.code(), message = this.message())
        }
    } catch (e: HttpException) {
        Log.i("--STATE", "-----------34" + e.message())
        ApiError(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        Log.i("--STATE", "-----------37" + e.message)
        ApiException(e)
    }
}

//TODO вариант 2
fun <T> Response<T>.handleBodyDto2(): T {
    val body = this.body()
    return if (this.isSuccessful) {
        body ?: throw InvalidResponseException("Response body is null")
    } else {
        val errorBody: ResponseBody? = errorBody()
        errorBody?.let {
            //тут нужно парсить errorBody в соответ с моделью от сервера и возвращать строку
            throw throwException(code(), errorBody.string())
        } ?: throw RuntimeException("Response body and error body is null")
    }
}

