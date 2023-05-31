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

    override suspend fun news(category: String): List<NewsModel> {
        return newsRestService.news(category).handleBodyDto().toListNewsModel()
    }

    override suspend fun categories(): List<String> {
        return newsRestService.categories()
    }

}