package com.example.featurePeoples.characters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.PeoplesInteractor
import com.example.navigation.KEY_PEOPLE_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleCharactersViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val peoplesInteractor: PeoplesInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private val peopleId
        get() = savedStateHandle.get<String>(KEY_PEOPLE_ID).orEmpty()

    private fun loadData() {
        viewModelScope.launch {
            sendState(PeopleCharactersLoading)
            when (val state = peoplesInteractor.castCreditsPeople(peopleId)) {
                is ResultState.Success -> {
                    sendState(PeopleCharactersSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(PeopleCharactersError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
    }

}