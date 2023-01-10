package com.example.domain.interactor

import com.example.domain.model.NewsModel
import com.example.domain.repository.NewsRepository
import javax.inject.Inject
import javax.inject.Singleton

// поработать с di
@Singleton
class NewsInteractor @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun loadNews(): List<NewsModel> = newsRepository.loadNews()

}