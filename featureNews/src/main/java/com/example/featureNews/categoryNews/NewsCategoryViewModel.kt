package com.example.featureNews.categoryNews

import androidx.lifecycle.viewModelScope
import com.example.common.BASE_DELAY
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.NewsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsCategoryViewModel @Inject constructor(
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            sendState(NewsCategoryLoading)
            delay(BASE_DELAY)
            when (val state = newsInteractor.categories()) {
                is ResultState.Success -> {
                    sendState(NewsCategorySuccess(state.data))
                }

                else -> {}
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is ShowNewsEvent -> {
                showNews(event.category)
            }

            else -> {}
        }
    }

    private fun showNews(category: String) {
        viewModelScope.launch {
            sendSideEffect(NewsCategoryEffect(category))
        }
    }

}