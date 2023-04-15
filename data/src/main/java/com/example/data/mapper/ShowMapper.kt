package com.example.data.mapper

import com.example.common.double
import com.example.common.int
import com.example.data.dto.shows.ShowDto
import com.example.data.dto.shows.ShowScheduleDto
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.model.shows.ShowScheduleModel

fun List<ShowDto>?.toListShowModel(): List<ListShowsModel> {
    return this?.map(::toShowListModel) ?: emptyList()
}

fun toShowListModel(showDto: ShowDto): ListShowsModel {
    return ListShowsModel(
        id = showDto.id.int(),
        mediumImage = showDto.showImageDto?.medium.orEmpty(),
        name = showDto.name.orEmpty(),
        genres = showDto.genres?.map { genre -> genre.orEmpty() } ?: emptyList()
    )
}

fun ShowDto?.toShowModel(): ShowModel {
    return ShowModel(
        id = this?.id.int(),
        tvrageId = this?.showExternalsDto?.tvrage.int().toString(),
        thetvdbId = this?.showExternalsDto?.thetvdb.int().toString(),
        mediumImage = this?.showImageDto?.medium.orEmpty(),
        originalImage = this?.showImageDto?.original.orEmpty(),
        name = this?.name.orEmpty(),
        summary = this?.summary.orEmpty(),
        language = this?.language.orEmpty(),
        genres = this?.genres?.map { genre -> genre.orEmpty() } ?: emptyList(),
        premiered = this?.premiered.orEmpty(),
        ended = this?.ended.orEmpty(),
        schedule = this?.showScheduleDto.toShowScheduleModel(),
        rating = this?.showRatingDto?.average.double(),
        officialSite = this?.officialSite.orEmpty(),
        url = this?.url.orEmpty(),
    )
}

fun ShowScheduleDto?.toShowScheduleModel(): ShowScheduleModel {
    return ShowScheduleModel(
        time = this?.time.orEmpty(),
        days = this?.days?.map { day -> day.orEmpty() } ?: emptyList()
    )
}