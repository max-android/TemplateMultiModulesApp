package com.example.featureQuotes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.interactor.QuoteInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val quoteInteractor: QuoteInteractor,
) : BaseViewModel() {

    init {

    }

    override fun obtainEvent(event: BaseEvent?) {

    }

    private fun doRequest() {
        viewModelScope.launch {

        }
    }


}