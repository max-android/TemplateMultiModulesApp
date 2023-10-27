package com.example.domain.model.beer

class BeerModel(
    val id: String,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String,
    val volume: AmountModel,
    val tips: String,
    val food: List<String>,
    val ingredient: IngredientModel
)