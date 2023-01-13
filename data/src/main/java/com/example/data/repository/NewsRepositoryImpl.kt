package com.example.data.repository

import com.example.data.common.*
import com.example.data.mapper.toListNewsModel
import com.example.data.network.NewsRestService
import com.example.domain.model.*
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
     private val newsRestService: NewsRestService
) : NewsRepository {

    override suspend fun loadNews(): List<NewsModel> {
        return newsRestService.news().handleBodyDto2().toListNewsModel()

//        try {
//            val newsResponse = newsRestService.news().handleBodyDto()
//        } catch (throwable: Throwable) {
//            Log.i("--STATE", "-----------23"+throwable.message)
//        }
//        val newsResponse = newsRestService.news().handleBodyDto()
//        return when (newsResponse) {
//            is ApiSuccess -> {
//                NewsDomainSuccess(newsResponse.data.toListNewsModel())
//            }
//            is ApiError -> {
//                NewsDomainError(newsResponse.code, newsResponse.message)
//            }
//            is ApiException -> {
//                NewsDomainException(newsResponse.throwable)
//            }
//        }
    }

}