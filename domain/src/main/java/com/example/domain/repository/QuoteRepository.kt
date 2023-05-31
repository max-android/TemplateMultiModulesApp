package com.example.domain.repository

import com.example.domain.model.quote.QuoteModel

interface QuoteRepository {

    suspend fun allQuote(): List<QuoteModel>

    suspend fun seriesQuote(): List<String>

    suspend fun colorsQuote(): List<String>

}