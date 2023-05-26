package com.example.featureShows.detailShows

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.ShowsInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.navigation.KEY_SHOWS_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay

@HiltViewModel
class ShowsDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        Log.i("--STATE", "-------------ShowsDetailViewModel INIT")
        loadData()
    }

    private fun loadData() {
        val showsId = savedStateHandle.get<String>(KEY_SHOWS_ID).orEmpty()
        viewModelScope.launch {
            sendState(ShowsDetailLoading)
            when (val state = showsInteractor.detailShow(showsId)) {
                is ResultState.Success -> {
                    sendState(ShowsDetailSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(ShowsDetailError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowSiteShowsEvent -> {
                showSiteShows(event.url)
            }

            else -> {}
        }
    }

    private fun showSiteShows(url: String) {
        viewModelScope.launch {
            sendSideEffect(ShowSiteShowsEffect(url))
        }
    }

}