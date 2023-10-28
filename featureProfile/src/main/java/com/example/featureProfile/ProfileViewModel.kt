package com.example.featureProfile

import androidx.lifecycle.SavedStateHandle
import com.example.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    init {
        obtainEvent(null)
       // val i = savedStateHandle.get<Int>("myKey")
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}