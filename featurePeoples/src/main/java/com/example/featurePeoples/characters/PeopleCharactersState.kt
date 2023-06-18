package com.example.featurePeoples.characters

import com.example.common.BaseViewModel
import com.example.domain.model.peoples.CharacterModel

sealed class PeopleCharactersState : BaseViewModel.BaseViewState
data class PeopleCharactersSuccess(val characters: List<CharacterModel>) : PeopleCharactersState()
object PeopleCharactersEmpty : PeopleCharactersState()
object PeopleCharactersLoading : PeopleCharactersState()
data class PeopleCharactersError(val exception: Throwable) : PeopleCharactersState()