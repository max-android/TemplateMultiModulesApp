package com.example.featureProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ProfileInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileInteractor: ProfileInteractor
) : ViewModel() {

// Сделать в ViewModelLight внутри 2 вида событий

    private val _state = MutableStateFlow<ProfileViewState?>(null)
    val state: StateFlow<ProfileViewState?> = _state.asStateFlow()

    init {
        obtainEvent()
    }

    fun obtainEvent() {
        showContentAction()
    }

    private fun showContentAction() {
        viewModelScope.launch {
            val profileModel = profileInteractor.loadProfile()
            _state.emit(ProfileViewState.SuccessProfileState(profileModel))
        }
    }

}