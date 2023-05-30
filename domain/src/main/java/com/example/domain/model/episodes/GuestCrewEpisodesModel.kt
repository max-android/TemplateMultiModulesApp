package com.example.domain.model.episodes

import com.example.domain.model.peoples.PeopleModel

class GuestCrewEpisodesModel(
    val peopleModel: PeopleModel,
    val guestCrewType: String
)