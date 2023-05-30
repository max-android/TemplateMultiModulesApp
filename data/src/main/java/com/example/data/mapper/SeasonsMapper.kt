package com.example.data.mapper

import com.example.common.int
import com.example.data.dto.shows.seasons.SeasonsDto
import com.example.domain.model.shows.seasons.SeasonsModel

fun List<SeasonsDto>?.toListSeasonsModel(): List<SeasonsModel> {
    return this?.map(::toSeasonsModel) ?: emptyList()
}

private fun toSeasonsModel(seasonsDto: SeasonsDto): SeasonsModel {
    return SeasonsModel(
        summary = seasonsDto.summary.orEmpty(),
        number = seasonsDto.number.int().toString(),
        mediumImage = seasonsDto.image?.medium.orEmpty(),
        originalImage = seasonsDto.image?.original.orEmpty(),
        premiereDate = seasonsDto.premiereDate.orEmpty(),
        endDate = seasonsDto.endDate.orEmpty(),
        webChannel = seasonsDto.webChannel.orEmpty(),
        name = seasonsDto.name.orEmpty(),
        episodeOrder = seasonsDto.episodeOrder.int().toString(),
        id = seasonsDto.id.int().toString(),
        url = seasonsDto.url.orEmpty(),
        site = seasonsDto.network?.officialSite.orEmpty()
    )
}