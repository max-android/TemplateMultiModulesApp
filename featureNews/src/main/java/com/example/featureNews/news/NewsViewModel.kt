package com.example.featureNews.news

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.NewsInteractor
import com.example.navigation.KEY_CATEGORY_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val categoryId = savedStateHandle.get<String>(KEY_CATEGORY_ID).orEmpty()
        viewModelScope.launch {
            sendState(NewsLoading)
            when (val state = newsInteractor.news(categoryId)) {
                is ResultState.Success -> {
                    sendState(NewsSuccess(state.data))
                }

                is ResultState.Error -> {
                    sendState(NewsError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}