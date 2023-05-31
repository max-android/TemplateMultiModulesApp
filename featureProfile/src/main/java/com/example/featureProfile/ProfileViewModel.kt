package com.example.featureProfile

import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.common.BaseViewModel
import com.example.common.ServerProblemException
import com.example.domain.common.ResultState
import com.example.domain.interactor.NewsInteractor
import com.example.domain.interactor.ProfileInteractor
import com.example.domain.model.NewsDomainError
import com.example.domain.model.NewsDomainException
import com.example.domain.model.NewsDomainSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val profileInteractor: ProfileInteractor,
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {

// Сделать в ViewModelLight внутри 2 вида событий

//    private val _state2 = MutableStateFlow<ProfileViewState?>(null)
//    val state2: StateFlow<ProfileViewState?> = _state2.asStateFlow()

    init {
        obtainEvent(null)
       // val i = savedStateHandle.get<Int>("myKey")
    }

    override fun obtainEvent(event: BaseEvent?) {
        showContentAction()
    }

    private fun showContentAction() {
        viewModelScope.launch {


            
        }
    }

}