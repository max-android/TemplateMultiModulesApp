package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toListQuoteModel
import com.example.data.network.QuoteRestService
import com.example.domain.model.quote.QuoteModel
import com.example.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteRestService: QuoteRestService
) : QuoteRepository {

    override suspend fun allQuote(): List<QuoteModel> {
        return quoteRestService.allQuote().handleBodyDto().toListQuoteModel()
    }

    override suspend fun seriesQuote(): List<String> {
        return quoteRestService.seriesQuote().handleBodyDto()
    }

    override suspend fun colorsQuote(): List<String> {
        return quoteRestService.colorsQuote().handleBodyDto()
    }
}