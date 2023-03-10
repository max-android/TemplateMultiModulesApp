package com.example.featureProfile

import android.util.Log
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
        obtainEvent()
        val i = savedStateHandle.get<Int>("myKey")
    }

    fun obtainEvent() {
        showContentAction()
    }

    private fun showContentAction() {
        viewModelScope.launch {

            val resultState = newsInteractor.loadNews()
            when (resultState) {
                is ResultState.Success -> {
                    sendState(ProfileViewState.SuccessProfileState(resultState.data))
                }
                is ResultState.Error -> {
                    Log.i("--STATE", "---------------Throwable: " + resultState.exception.message)
                    sendState(ProfileViewState.ExceptionProfileState(resultState.exception))
                    sendSideEffect(ProfileSideEffect.ShowToast)
                }
            }


            val profileModel = profileInteractor.loadProfile()
            try {
                // val news = newsInteractor.loadNews()

                // } catch (e: ServerProblemException) {
                //  Log.i("--STATE", "---------------HttpException: "+e.message)
                //_state.emit(ProfileViewState.ErrorProfileState(e.response.code, e.response.message))
            } catch (e: Throwable) {
                Log.i("--STATE", "---------------Throwable: " + e.message)

                //_state.emit(ProfileViewState.ExceptionProfileState(e))
            }


//            when (news) {
//                is NewsDomainSuccess -> {
//                    _state.emit(ProfileViewState.SuccessProfileState(news.data))
//                    news.data.forEach {
//                Log.i("--DATA", "--------" + it.imageUrl)
//            }
//                }
//                is NewsDomainError -> {
//
//                }
//                is NewsDomainException -> {
//
//                }
//            }


        }
    }

}