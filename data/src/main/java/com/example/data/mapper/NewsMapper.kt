package com.example.data.mapper

import com.example.data.dto.news.AllNewsDto
import com.example.data.dto.news.NewsDto
import com.example.domain.model.NewsModel

fun AllNewsDto?.toListNewsModel(): List<NewsModel> {
    return this?.data?.map(::toNewsModel) ?: emptyList()
}

fun toNewsModel(newsDto: NewsDto): NewsModel {
    return NewsModel(
        id = newsDto.id.orEmpty(),
        title = newsDto.title.orEmpty(),
        author = newsDto.author.orEmpty(),
        date = newsDto.date.orEmpty(),
        imageUrl = newsDto.imageUrl.orEmpty(),
        readMoreUrl = newsDto.readMoreUrl.orEmpty(),
        content = newsDto.content.orEmpty(),
    )
}