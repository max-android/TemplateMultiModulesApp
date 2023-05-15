package com.example.featureShows.shows

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.ShowsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            sendState(ShowsListLoading)
            val state = showsInteractor.allShows()
            // val state = showsInteractor.detailShow("1")
            when (state) {
                is ResultState.Success -> {
                    if (state.data.isEmpty()) {
                        sendState(ShowsListEmpty)
                    } else {
                        sendState(ShowsListSuccess(state.data))
                    }
                }
                is ResultState.Error -> {
                    sendState(ShowsListError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowsDetailEvent -> {
                showDetailEvent(event.showsId)
            }
            else -> {}
        }
    }

    private fun showDetailEvent(showId: String) {
        viewModelScope.launch {
            sendSideEffect(ShowsDetailEffect(showId))
        }
    }

}