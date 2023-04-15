package com.example.domain.model.shows

class ShowModel(
    val id: Int,
    val tvrageId: String,
    val thetvdbId: String,
    val mediumImage: String,
    val originalImage: String,
    val name: String,
    val summary: String,
    val language: String,
    val genres: List<String>,
    val premiered: String,
    val ended: String,
    val schedule: ShowScheduleModel,
    val rating: Double,
    val officialSite: String,
    val url: String,
)

class ShowScheduleModel(
    val time: String,
    val days: List<String>,
)

class ListShowsModel(
    val id: Int,
    val mediumImage: String,
    val name: String,
    val genres: List<String>
)