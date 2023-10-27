package com.example.data.mapper

import com.example.common.double
import com.example.data.dto.beer.BeerItemDto
import com.example.data.dto.beer.MaltDto
import com.example.domain.model.beer.AmountModel
import com.example.domain.model.beer.BeerModel
import com.example.domain.model.beer.IngredientModel
import com.example.domain.model.beer.MaltModel

fun List<BeerItemDto>?.toListBeerModel(): List<BeerModel> {
    return this?.map { it.toBeerModel() } ?: emptyList()
}

fun BeerItemDto?.toBeerModel(): BeerModel {
    return BeerModel(
        id = this?.id.orEmpty(),
        name = this?.name.orEmpty(),
        tagline = this?.tagline.orEmpty(),
        description = this?.description.orEmpty(),
        imageUrl = this?.imageUrl.orEmpty(),
        volume = AmountModel(
            value = this?.volume?.value.double(),
            unit = this?.volume?.unit.orEmpty()
        ),
        tips = this?.tips.orEmpty(),
        food = this?.food ?: listOf(),
        ingredient = IngredientModel(
            malt = this?.ingredient?.malt.toListMaltModel(),
            hops = this?.ingredient?.hops.toListMaltModel(),
            yeast = this?.ingredient?.yeast.orEmpty()
        )
    )
}

fun List<MaltDto>?.toListMaltModel(): List<MaltModel> {
    return this?.map(::toMaltModel) ?: emptyList()
}

fun toMaltModel(maltDto: MaltDto): MaltModel {
    return MaltModel(
        name = maltDto.name.orEmpty(),
        amount = AmountModel(
            value = maltDto.amount?.value.double(),
            unit = maltDto.amount?.unit.orEmpty()
        )
    )
}