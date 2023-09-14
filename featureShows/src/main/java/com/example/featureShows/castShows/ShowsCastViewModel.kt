package com.example.featureShows.castShows

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
class ShowsCastViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val showsId = savedStateHandle.get<String>(KEY_SHOWS_ID).orEmpty()
        viewModelScope.launch {
            sendState(ShowsCastLoading)
            when (val state = showsInteractor.castShows(showsId)) {
                is ResultState.Success -> {
                    sendState(ShowsCastSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(ShowsCastError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}