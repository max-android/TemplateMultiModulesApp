package com.example.data.mapper

import com.example.common.int
import com.example.data.dto.quote.QuoteDto
import com.example.domain.model.quote.QuoteModel

fun List<QuoteDto>?.toListQuoteModel(): List<QuoteModel> {
    return this?.map(::toQuoteModel) ?: emptyList()
}

fun toQuoteModel(quoteDto: QuoteDto): QuoteModel {
    return QuoteModel(
        id = quoteDto.id.int().toString(),
        quote = quoteDto.quote.orEmpty(),
        author = quoteDto.author.orEmpty(),
        series = quoteDto.series.orEmpty()
    )
}