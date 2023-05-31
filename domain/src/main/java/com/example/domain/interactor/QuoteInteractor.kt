package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.quote.QuoteModel
import com.example.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteInteractor @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

    suspend fun allQuote(): ResultState<List<QuoteModel>> {
        return try {
            val quotes = quoteRepository.allQuote()
            ResultState.Success(quotes)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun seriesQuote(): ResultState<List<String>> {
        return try {
            val seriesQuote = quoteRepository.seriesQuote()
            ResultState.Success(seriesQuote)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun colorsQuote(): ResultState<List<String>> {
        return try {
            val colorsQuote = quoteRepository.colorsQuote()
            ResultState.Success(colorsQuote)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}