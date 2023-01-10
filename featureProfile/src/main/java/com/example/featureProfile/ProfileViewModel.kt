package com.example.featureProfile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.NewsInteractor
import com.example.domain.interactor.ProfileInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileInteractor: ProfileInteractor,
    private val newsInteractor: NewsInteractor
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
            val news = newsInteractor.loadNews()
            news.forEach {
                Log.i("--DATA", "--------" + it.imageUrl)
            }
            _state.emit(ProfileViewState.SuccessProfileState(profileModel))
        }
    }

}