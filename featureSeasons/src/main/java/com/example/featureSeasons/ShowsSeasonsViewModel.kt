package com.example.featureSeasons

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.ShowsInteractor
import com.example.navigation.KEY_SHOWS_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsSeasonsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val showsId = savedStateHandle.get<String>(KEY_SHOWS_ID).orEmpty()
        viewModelScope.launch {
            sendState(ShowsSeasonsLoading)
            when (val state = showsInteractor.seasonsShows(showsId)) {
                is ResultState.Success -> {
                    sendState(ShowsSeasonsSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(ShowsSeasonsError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowSiteSeasonsEvent -> {
                showSiteSeasons(event.url)
            }

            else -> {}
        }
    }

    private fun showSiteSeasons(url: String) {
        viewModelScope.launch {
            sendSideEffect(ShowSiteSeasonsEffect(url))
        }
    }

}