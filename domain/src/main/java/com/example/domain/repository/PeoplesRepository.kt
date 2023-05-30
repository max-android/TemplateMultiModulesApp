package com.example.domain.repository

import com.example.domain.model.peoples.CharacterModel
import com.example.domain.model.peoples.PeopleModel

interface PeoplesRepository {

    suspend fun allPeoples(): List<PeopleModel>

    suspend fun detailPeople(idPeople: String): PeopleModel

    suspend fun castCreditsPeople(idPeople: String): List<String>

    suspend fun charactersPeople(idCharacter: String): List<CharacterModel>

    suspend fun searchPeoples(people: String): List<PeopleModel>

}