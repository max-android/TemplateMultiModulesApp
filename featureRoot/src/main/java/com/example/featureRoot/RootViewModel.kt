package com.example.featureRoot

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor() : BaseViewModel() {

    init {
        viewModelScope.launch {
            sendState(RootViewState.SuccessRoot(false))
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}