package com.example.domain.model.openCollective

class EventModel(
    val image: String,
    val name: String,
    val description: String,
    val longDescription: String,
    val startsAt: String,
    val location: LocationEventModel,
    val id: String,
    val endsAt: String,
    val slug: String,
    val url: String,
    val info: String
)