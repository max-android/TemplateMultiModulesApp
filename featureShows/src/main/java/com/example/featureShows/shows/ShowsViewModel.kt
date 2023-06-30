package com.example.featureShows.shows

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.ShowsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.common.BASE_DELAY

@HiltViewModel
class ShowsViewModel @Inject constructor(
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        Log.i("--STATE", "-------------ShowsViewModel INIT")
        loadData()
    }

    private fun loadData() {
        Log.i("--STATE", "-------------ShowsComponent loadData()")
        viewModelScope.launch {
            sendState(ShowsListLoading)
            when (val state = showsInteractor.allShows()) {
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
            is ShowShowsDetailEvent -> {
                showDetailEvent(event.showsId)
            }

            is ShowSearchEvent -> {
                showSearchEvent(event.search)
            }

            else -> {}
        }
    }

    private fun showDetailEvent(showId: String) {
        viewModelScope.launch {
            sendSideEffect(ShowShowsDetailEffect(showId))
        }
    }

    private fun showSearchEvent(search: String) {
        viewModelScope.launch {
            if (search.length < SEARCH_BORDER) return@launch
            delay(BASE_DELAY)
            when (val state = showsInteractor.searchShows(search)) {
                is ResultState.Success -> {
                    Log.i("--STATE", "-------------searchShows")
                    sendState(ShowsListSuccess(state.data, search = search))
                }

                is ResultState.Error -> {
                    sendState(ShowsListError(state.exception))
                }
            }
        }
    }

    companion object  {
        private const val SEARCH_BORDER = 3
    }

}