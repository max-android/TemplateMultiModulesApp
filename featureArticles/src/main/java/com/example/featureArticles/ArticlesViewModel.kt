package com.example.featureArticles

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesViewModel @Inject constructor() : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            sendState(InitArticles)
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowNewsEvent -> {
                showNewsEvent()
            }

            is ShowPlayersEvent -> {
                showPlayersEvent()
            }
            else -> {}
        }
    }

    private fun showNewsEvent() {
        viewModelScope.launch {
            sendSideEffect(NewsEffect)
        }
    }

    private fun showPlayersEvent() {
        viewModelScope.launch {
            sendSideEffect(PlayersEffect)
        }
    }

}