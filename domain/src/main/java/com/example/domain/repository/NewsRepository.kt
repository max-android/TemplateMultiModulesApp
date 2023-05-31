package com.example.domain.repository

import com.example.domain.model.NewsModel

interface NewsRepository {

    suspend fun categories(): List<String>
    suspend fun news(category: String): List<NewsModel>

}