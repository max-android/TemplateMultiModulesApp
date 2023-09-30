package com.example.featureEpisodes.crewEpisode

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.EpisodesInteractor
import com.example.navigation.KEY_EPISODE_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeCrewViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val episodesInteractor: EpisodesInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val episodeId = savedStateHandle.get<String>(KEY_EPISODE_ID).orEmpty()
        viewModelScope.launch {
            sendState(EpisodeCrewLoading)
            when (val state = episodesInteractor.guestCrewEpisode(episodeId)) {
                is ResultState.Success -> {
                    sendState(EpisodeCrewSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(EpisodeCrewError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }


}