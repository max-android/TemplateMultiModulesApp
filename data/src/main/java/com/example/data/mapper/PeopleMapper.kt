package com.example.data.mapper

import com.example.data.dto.peoples.cast.PeopleCastCreditsDto
import com.example.data.dto.peoples.characters.CharacterDto
import com.example.data.dto.peoples.person.PeopleDto
import com.example.data.dto.peoples.person.SearchPeopleDto
import com.example.domain.model.peoples.CharacterModel
import com.example.domain.model.peoples.PeopleModel

fun List<PeopleDto>?.toListPeopleModel(): List<PeopleModel> {
    return this?.map(::toPeoplesModel) ?: emptyList()
}

fun List<SearchPeopleDto>?.toListSearchPeopleModel(): List<PeopleModel> {
    return this?.map { searchPeopleDto -> searchPeopleDto.person.toPeopleModel() } ?: emptyList()
}

private fun toPeoplesModel(peopleDto: PeopleDto): PeopleModel {
    return PeopleModel(
        id = peopleDto.id.toString(),
        name = peopleDto.name.orEmpty(),
        gender = peopleDto.gender.orEmpty(),
        url = peopleDto.url.orEmpty(),
        birthday = peopleDto.birthday.orEmpty(),
        country = peopleDto.countryPeopleDto?.name.orEmpty(),
        originalImage = peopleDto.imagePeopleDto?.original.orEmpty(),
        mediumImage = peopleDto.imagePeopleDto?.medium.orEmpty(),
    )
}

fun PeopleDto?.toPeopleModel(): PeopleModel {
    return PeopleModel(
        id = this?.id.toString(),
        name = this?.name.orEmpty(),
        gender = this?.gender.orEmpty(),
        url = this?.url.orEmpty(),
        birthday = this?.birthday.orEmpty(),
        country = this?.countryPeopleDto?.name.orEmpty(),
        originalImage = this?.imagePeopleDto?.original.orEmpty(),
        mediumImage = this?.imagePeopleDto?.medium.orEmpty(),
    )
}

fun List<PeopleCastCreditsDto>?.toListCharacterIds(): List<String> {
    return this?.map(::toPersonCastCreditsIds) ?: emptyList()
}

private fun toPersonCastCreditsIds(personCastCreditsDto: PeopleCastCreditsDto): String {
    return personCastCreditsDto.links?.character?.href
        ?.replaceBeforeLast("/", "")
        ?.replace("/", "")
        .orEmpty()
}

fun List<CharacterDto>?.toListCharacterModel(): List<CharacterModel> {
    return this?.map(::toCharactersModel) ?: emptyList()
}

private fun toCharactersModel(characterDto: CharacterDto): CharacterModel {
    return CharacterModel(
        id = characterDto.id.toString(),
        name = characterDto.name.orEmpty(),
        originalImage = characterDto.image?.original.orEmpty(),
        mediumImage = characterDto.image?.medium.orEmpty(),
    )
}

fun CharacterDto?.toCharacterModel(): CharacterModel {
    return CharacterModel(
        id = this?.id.toString(),
        name = this?.name.orEmpty(),
        originalImage = this?.image?.original.orEmpty(),
        mediumImage = this?.image?.medium.orEmpty(),
    )
}