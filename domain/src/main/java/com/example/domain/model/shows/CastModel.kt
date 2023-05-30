package com.example.domain.model.shows

import com.example.domain.model.peoples.CharacterModel
import com.example.domain.model.peoples.PeopleModel

class CastModel(
    val peopleModel: PeopleModel,
    val characterModel: CharacterModel
)