package com.example.featureProfile

import androidx.lifecycle.SavedStateHandle
import com.example.common.BaseViewModel
import com.example.domain.interactor.NewsInteractor
import com.example.domain.interactor.ProfileInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val profileInteractor: ProfileInteractor,
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {

    init {
        obtainEvent(null)
       // val i = savedStateHandle.get<Int>("myKey")
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}