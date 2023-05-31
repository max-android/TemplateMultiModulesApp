package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.NewsModel
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun categories(): ResultState<List<String>> {
        return ResultState.Success(newsRepository.categories())
    }

    suspend fun news(category: String): ResultState<List<NewsModel>> {
        return try {
            val news = newsRepository.news(category)
            ResultState.Success(news)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}