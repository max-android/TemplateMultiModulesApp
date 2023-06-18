package com.example.featurePeoples.peoples

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.PeoplesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeoplesViewModel @Inject constructor(
    private val peoplesInteractor: PeoplesInteractor
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            sendState(PeoplesListLoading)
            when (val state = peoplesInteractor.allPeoples()) {
                is ResultState.Success -> {
                    if (state.data.isEmpty()) {
                        sendState(PeoplesListEmpty)
                    } else {
                        sendState(PeoplesListSuccess(state.data))
                    }
                }

                is ResultState.Error -> {
                    sendState(PeoplesListError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowPeopleDetailEvent -> {
                showDetailEvent(event.peopleId)
            }

            else -> {}
        }
    }

    private fun showDetailEvent(peopleId: String) {
        viewModelScope.launch {
            sendSideEffect(PeopleDetailEffect(peopleId))
        }
    }

}