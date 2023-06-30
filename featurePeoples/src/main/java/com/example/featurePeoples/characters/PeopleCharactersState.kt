package com.example.featurePeoples.characters

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.peoples.CharacterModel

sealed class PeopleCharactersState : BaseViewModel.BaseViewState
@Immutable
data class PeopleCharactersSuccess(val character: CharacterModel) : PeopleCharactersState()
object PeopleCharactersEmpty : PeopleCharactersState()
object PeopleCharactersLoading : PeopleCharactersState()
data class PeopleCharactersError(val exception: Throwable) : PeopleCharactersState()