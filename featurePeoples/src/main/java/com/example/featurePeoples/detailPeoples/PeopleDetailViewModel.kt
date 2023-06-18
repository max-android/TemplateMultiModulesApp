package com.example.featurePeoples.detailPeoples

import android.util.Log
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
class PeopleDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val peoplesInteractor: PeoplesInteractor,
) : BaseViewModel() {

    init {
        Log.i("--STATE", "-------------ShowsDetailViewModel INIT")
        loadData()
    }

    private val peopleId
        get() = savedStateHandle.get<String>(KEY_PEOPLE_ID).orEmpty()

    private fun loadData() {
        viewModelScope.launch {
            sendState(PeopleDetailLoading)
            when (val state = peoplesInteractor.detailPeople(peopleId)) {
                is ResultState.Success -> {
                    sendState(PeopleDetailSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(PeopleDetailError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowSitePeoplesEvent -> {
                showSiteShows(event.url)
            }

            is ShowPeopleCharactersEvent -> {
                showPeopleCharacters()
            }

            else -> {}
        }
    }

    private fun showSiteShows(url: String) {
        viewModelScope.launch {
            sendSideEffect(ShowSitePeoplesEffect(url))
        }
    }

    private fun showPeopleCharacters() {
        viewModelScope.launch {
            sendSideEffect(PeopleCharactersEffect(peopleId))
        }
    }

}