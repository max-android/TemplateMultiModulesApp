package com.example.data.common

import com.example.common.*
import com.example.data.dto.ErrorResponse
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
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

fun <T : Any> Response<T>.oldHandleBodyDto(): ApiResult<T> {
    return try {
        val body = this.body()
        if (this.isSuccessful && body != null) {
            ApiSuccess(body)
        } else {
            ApiError(code = this.code(), message = this.message())
        }
    } catch (e: HttpException) {
        ApiError(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        ApiException(e)
    }
}

fun <T> Response<T>.handleBodyDto(): T {
    val body = this.body()
    return if (this.isSuccessful) {
        body ?: throw InvalidResponseException("Response body is null")
    } else {
        val errorBody: ResponseBody? = errorBody()
        errorBody?.let {
            val errorResponse: ErrorResponse? = parseError(errorBody)
            throw throwException(code(), errorResponse?.message.orEmpty())
        } ?: throw RuntimeException("Response body and error body is null")
    }
}

fun parseError(errorBody: ResponseBody): ErrorResponse? {
    val jsonAdapter = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        .adapter(ErrorResponse::class.java).lenient()
    return try {
        jsonAdapter.fromJson(errorBody.string())
    } catch (e: Throwable) {
        null
    }
}

fun parseError(error: Throwable?): ErrorResponse? {
    val errorJsonString: String? = (error as? HttpException)?.response()?.errorBody()?.string()
    val jsonAdapter = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        .adapter(ErrorResponse::class.java).lenient()
    return try {
        errorJsonString?.let {
            jsonAdapter.fromJson(errorJsonString)
        }
    } catch (e: JsonDataException) {
        null
    }
}