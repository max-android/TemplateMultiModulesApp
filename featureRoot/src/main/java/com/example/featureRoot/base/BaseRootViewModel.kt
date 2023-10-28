package com.example.featureRoot.base

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.featureRoot.root.SuccessRoot
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseRootViewModel @Inject constructor() : BaseViewModel() {

    init {
        viewModelScope.launch {
            sendState(SuccessRoot(false))
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}