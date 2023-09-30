package com.example.featureEpisodes.episodes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.EpisodesInteractor
import com.example.navigation.KEY_SHOWS_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val episodesInteractor: EpisodesInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val showsId = savedStateHandle.get<String>(KEY_SHOWS_ID).orEmpty()
        viewModelScope.launch {
            sendState(EpisodesLoading)
            when (val state = episodesInteractor.episodesShows(showsId)) {
                is ResultState.Success -> {
                    if (state.data.isEmpty()) {
                        sendState(EpisodesEmpty)
                    } else {
                        sendState(EpisodesSuccess(state.data))
                    }
                }

                is ResultState.Error -> {
                    sendState(EpisodesError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowEpisodeDetailEvent -> {
                showEpisodeDetailEvent(event.episodesId)
            }
            is ShowEpisodeCastEvent -> {
                showEpisodeCastEvent(event.episodesId)
            }
            is ShowEpisodeCrewEvent -> {
                showEpisodesCrewEvent(event.episodesId)
            }
            else -> {}
        }
    }

    private fun showEpisodeDetailEvent(episodesId: String) {
        viewModelScope.launch {
            sendSideEffect(ShowEpisodeDetailEffect(episodesId))
        }
    }

    private fun showEpisodeCastEvent(episodesId: String) {
        viewModelScope.launch {
            sendSideEffect(ShowEpisodesCastEffect(episodesId))
        }
    }

    private fun showEpisodesCrewEvent(episodesId: String) {
        viewModelScope.launch {
            sendSideEffect(ShowEpisodesCrewEffect(episodesId))
        }
    }


}