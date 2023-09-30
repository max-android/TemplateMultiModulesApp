package com.example.featureEpisodes.detailEpisodes

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
class EpisodeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val episodesInteractor: EpisodesInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val episodeId = savedStateHandle.get<String>(KEY_EPISODE_ID).orEmpty()
        viewModelScope.launch {
            sendState(EpisodeDetailLoading)
            when (val state = episodesInteractor.detailEpisode(episodeId)) {
                is ResultState.Success -> {
                    sendState(EpisodeDetailSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(EpisodeDetailError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}