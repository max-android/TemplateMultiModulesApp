package com.example.data.di

import android.content.Context
import com.example.common.CONNECT_TIMEOUT
import com.example.common.NEWS_BASE_URL
import com.example.common.READ_TIMEOUT
import com.example.common.WRITE_TIMEOUT
import com.example.data.BuildConfig
import com.example.data.common.createRestService
import com.example.data.network.ApiService
import com.example.data.network.InternetConnectionService
import com.example.data.network.InternetInterceptor
import com.example.data.network.NewsRestService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(@ApplicationContext applicationContext: Context): ApiService {
        return ApiService(applicationContext)
    }

    @Provides
    @Singleton
    fun provideInternetConnectionService(
        @ApplicationContext appContext: Context
    ): InternetConnectionService = InternetConnectionService(appContext)

    @Provides
    @Singleton
    fun provideInternetInterceptor(
        netService: InternetConnectionService
    ): InternetInterceptor = InternetInterceptor(netService)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        netInterceptor: InternetInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                addInterceptor(netInterceptor)
                addInterceptor(HttpLoggingInterceptor().also {
                    it.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                })
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            }.build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NewsRemoteApi

    @NewsRemoteApi
    @Provides
    @Singleton
    fun provideNewsRestService(
        moshiConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): NewsRestService = createRestService(
        moshiConverterFactory,
        okHttpClient,
        NEWS_BASE_URL,
        NewsRestService::class.java
    )
}