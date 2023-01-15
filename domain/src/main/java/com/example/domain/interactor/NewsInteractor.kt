package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.NewsModel
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun loadNews(): ResultState<List<NewsModel>> {
        return try {
            val mews = newsRepository.loadNews()
            ResultState.Success(mews)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}