package com.example.domain.repository

import com.example.domain.model.NewsModel

//TODO удалить
interface NewsRepository {

    suspend fun loadNews(): List<NewsModel>

}