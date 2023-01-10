package com.example.domain.repository

import com.example.domain.model.NewsModel

interface NewsRepository {

    suspend fun loadNews(): List<NewsModel>

}