package com.example.data.mapper

import com.example.data.dto.brewery.BreweryDto
import com.example.domain.model.brewery.BreweryModel

fun List<BreweryDto>?.toListBreweryModel(): List<BreweryModel> {
    return this?.map(::toBreweryModel) ?: emptyList()
}

fun toBreweryModel(breweryDto: BreweryDto): BreweryModel {
    return BreweryModel(
        id = breweryDto.id.orEmpty(),
        name = breweryDto.name.orEmpty(),
        city = breweryDto.city.orEmpty(),
        country = breweryDto.country.orEmpty(),
        longitude = breweryDto.longitude.orEmpty(),
        latitude = breweryDto.latitude.orEmpty(),
        phone = breweryDto.phone.orEmpty(),
        site = breweryDto.site.orEmpty(),
        state = breweryDto.state.orEmpty(),
        street = breweryDto.street.orEmpty(),
    )
}