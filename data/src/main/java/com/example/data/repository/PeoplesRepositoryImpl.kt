package com.example.data.repository

import com.example.data.common.handleBodyDto
import com.example.data.mapper.toListCharacterIds
import com.example.data.mapper.toListCharacterModel
import com.example.data.mapper.toListPeopleModel
import com.example.data.mapper.toListSearchPeopleModel
import com.example.data.mapper.toPeopleModel
import com.example.data.network.TvShowsRestService
import com.example.domain.model.peoples.CharacterModel
import com.example.domain.model.peoples.PeopleModel
import com.example.domain.repository.PeoplesRepository
import javax.inject.Inject

class PeoplesRepositoryImpl @Inject constructor(
    private val tvShowsRestService: TvShowsRestService
) : PeoplesRepository {

    override suspend fun allPeoples(): List<PeopleModel> {
        return tvShowsRestService.allPeoples().handleBodyDto().toListPeopleModel()
    }

    override suspend fun detailPeople(idPeople: String): PeopleModel {
        return tvShowsRestService.detailPeople(idPeople).handleBodyDto().toPeopleModel()
    }

    override suspend fun castCreditsPeople(idPeople: String): List<String> {
        return tvShowsRestService.castCreditsPeople(idPeople).handleBodyDto().toListCharacterIds()
    }

    override suspend fun charactersPeople(idCharacter: String): List<CharacterModel> {
        return tvShowsRestService.charactersPeople(idCharacter).handleBodyDto().toListCharacterModel()
    }

    override suspend fun searchPeoples(people: String): List<PeopleModel> {
        return tvShowsRestService.searchPeoples(people).handleBodyDto().toListSearchPeopleModel()
    }

}