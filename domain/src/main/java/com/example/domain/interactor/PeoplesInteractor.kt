package com.example.domain.interactor

import com.example.domain.common.ResultState
import com.example.domain.model.peoples.CharacterModel
import com.example.domain.model.peoples.PeopleModel
import com.example.domain.repository.PeoplesRepository
import javax.inject.Inject

class PeoplesInteractor @Inject constructor(
    private val peoplesRepository: PeoplesRepository
) {

    suspend fun allPeoples(): ResultState<List<PeopleModel>> {
        return try {
            val peoples = peoplesRepository.allPeoples()
            ResultState.Success(peoples)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun detailPeople(idPeople: String): ResultState<PeopleModel> {
        return try {
            val people = peoplesRepository.detailPeople(idPeople)
            ResultState.Success(people)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun castCreditsPeople(idPeople: String): ResultState<List<String>> {
        return try {
            val charactersIds = peoplesRepository.castCreditsPeople(idPeople)
            ResultState.Success(charactersIds)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun charactersPeople(idCharacter: String): ResultState<List<CharacterModel>> {
        return try {
            val characters = peoplesRepository.charactersPeople(idCharacter)
            ResultState.Success(characters)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

    suspend fun searchPeoples(people: String): ResultState<List<PeopleModel>> {
        return try {
            val peoples = peoplesRepository.searchPeoples(people)
            ResultState.Success(peoples)
        } catch (throwable: Throwable) {
            ResultState.Error(throwable)
        }
    }

}