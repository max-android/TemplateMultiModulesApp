package com.example.data.network

import com.example.common.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class InternetInterceptor(private val netService: InternetConnectionService) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            if (!netService.isOnline()) {
                throw NoInternetException(RuntimeException())
            }
            return chain.proceed(chain.request())
        } catch (e: IOException) {
            if (!netService.isOnline()) {
                throw NoInternetException(e)
            }
            throw e
        }
    }
}