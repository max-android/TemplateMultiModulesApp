package com.example.featureProfile.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : BaseViewModel() {

    init {
        loadData()
        // val i = savedStateHandle.get<Int>("myKey")
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

    private fun loadData() {
        viewModelScope.launch {
            sendState(SuccessProfileState)
        }
    }

}