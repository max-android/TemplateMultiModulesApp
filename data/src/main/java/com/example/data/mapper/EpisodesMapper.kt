package com.example.data.mapper

import com.example.common.double
import com.example.common.int
import com.example.data.dto.episodes.EpisodesDto
import com.example.data.dto.episodes.GuestCastEpisodesDto
import com.example.data.dto.episodes.GuestCrewEpisodesDto
import com.example.domain.model.episodes.EpisodesModel
import com.example.domain.model.episodes.GuestCastEpisodesModel
import com.example.domain.model.episodes.GuestCrewEpisodesModel

fun List<EpisodesDto>?.toListEpisodeModel(): List<EpisodesModel> {
    return this?.map(::toEpisodesModel) ?: emptyList()
}

private fun toEpisodesModel(episodesDto: EpisodesDto): EpisodesModel {
    return EpisodesModel(
        id = episodesDto.id.int().toString(),
        name = episodesDto.name.orEmpty(),
        url = episodesDto.url.orEmpty(),
        summary = episodesDto.summary.orEmpty(),
        mediumImage = episodesDto.image?.medium.orEmpty(),
        originalImage = episodesDto.image?.original.orEmpty(),
        airdate = episodesDto.airdate.orEmpty(),
        rating = episodesDto.rating?.average?.double().toString(),
        duration = episodesDto.runtime.int().toString(),
        airtime = episodesDto.airtime.orEmpty(),
        number = episodesDto.number.int().toString(),
        season = episodesDto.season.int().toString(),
    )
}

fun EpisodesDto?.toEpisodeModel(): EpisodesModel {
    return EpisodesModel(
        id = this?.id.int().toString(),
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty(),
        summary = this?.summary.orEmpty(),
        mediumImage = this?.image?.medium.orEmpty(),
        originalImage = this?.image?.original.orEmpty(),
        airdate = this?.airdate.orEmpty(),
        rating = this?.rating?.average?.double().toString(),
        duration = this?.runtime.int().toString(),
        airtime = this?.airtime.orEmpty(),
        number = this?.number.int().toString(),
        season = this?.season.int().toString(),
    )
}

fun List<GuestCastEpisodesDto>?.toListGuestCastEpisodesModel(): List<GuestCastEpisodesModel> {
    return this?.map(::toGuestCastEpisodesModel) ?: emptyList()
}

private fun toGuestCastEpisodesModel(dto: GuestCastEpisodesDto): GuestCastEpisodesModel {
    return GuestCastEpisodesModel(
        peopleModel = dto.person.toPeopleModel(),
        characterModel = dto.character.toCharacterModel()
    )
}

fun List<GuestCrewEpisodesDto>?.toListGuestCrewEpisodesModel(): List<GuestCrewEpisodesModel> {
    return this?.map(::toGuestCrewEpisodesModel) ?: emptyList()
}

private fun toGuestCrewEpisodesModel(dto: GuestCrewEpisodesDto): GuestCrewEpisodesModel {
    return GuestCrewEpisodesModel(
        peopleModel = dto.person.toPeopleModel(),
        guestCrewType = dto.guestCrewType.orEmpty()
    )
}