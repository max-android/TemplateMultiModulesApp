package com.example.data.mapper

import com.example.data.dto.NewsDto
import com.example.domain.model.NewsModel

fun toNewsModel(newsDto: NewsDto): NewsModel {
    return NewsModel(newsDto.title, newsDto.imageUrl)
}

fun List<NewsDto>.toListNewsModel(): List<NewsModel> {
    return this.map(::toNewsModel)
}