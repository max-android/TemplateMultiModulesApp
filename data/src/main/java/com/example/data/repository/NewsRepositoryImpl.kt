package com.example.data.repository

import com.example.data.mapper.toListNewsModel
import com.example.data.network.NewsRestService
import com.example.domain.model.NewsModel
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRestService: NewsRestService
) : NewsRepository {

    override suspend fun loadNews(): List<NewsModel> {
        return newsRestService.news().toListNewsModel()
    }

}