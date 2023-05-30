package com.example.data.mapper

import com.example.common.double
import com.example.common.int
import com.example.data.dto.episodes.GuestCastEpisodesDto
import com.example.data.dto.shows.CastDto
import com.example.data.dto.shows.CrewDto
import com.example.data.dto.shows.SearchShowsDto
import com.example.data.dto.shows.ShowDto
import com.example.data.dto.shows.ShowScheduleDto
import com.example.data.dto.shows.image.ShowsImageDto
import com.example.domain.model.episodes.GuestCastEpisodesModel
import com.example.domain.model.shows.CastModel
import com.example.domain.model.shows.CrewModel
import com.example.domain.model.shows.ListShowsModel
import com.example.domain.model.shows.ShowModel
import com.example.domain.model.shows.ShowScheduleModel
import com.example.domain.model.shows.ShowsImageModel

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
        rating = this?.showRatingDto?.average.double().toString(),
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

fun List<CrewDto>?.toListCrewModel(): List<CrewModel> {
    return this?.map(::toCrewModel) ?: emptyList()
}

private fun toCrewModel(crewDto: CrewDto): CrewModel {
    return CrewModel(
        typeCrew = crewDto.typeCrew.orEmpty(),
        people = crewDto.people.toPeopleModel()
    )
}

fun List<CastDto>?.toListCastModel(): List<CastModel> {
    return this?.map(::toCastModel) ?: emptyList()
}

private fun toCastModel(castDto: CastDto): CastModel {
    return CastModel(
        peopleModel = castDto.person.toPeopleModel(),
        characterModel = castDto.character.toCharacterModel()
    )
}

fun List<ShowsImageDto>?.toListShowsImageModel(): List<ShowsImageModel> {
    return this?.map(::toShowsImageModel) ?: emptyList()
}

private fun toShowsImageModel(showsImageDto: ShowsImageDto): ShowsImageModel {
    return ShowsImageModel(
        id = showsImageDto.id.int().toString(),
        type = showsImageDto.type.orEmpty(),
        original = showsImageDto.resolutions?.original?.url.orEmpty(),
        medium = showsImageDto.resolutions?.medium?.url.orEmpty(),
    )
}

fun List<SearchShowsDto>?.toListSearchShowsModel(): List<ShowModel> {
    return this?.map { searchItem -> searchItem.show.toShowModel() } ?: emptyList()
}