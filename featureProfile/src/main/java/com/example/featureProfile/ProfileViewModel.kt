package com.example.featureProfile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.common.ServerProblemException
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



            try {
                val news = newsInteractor.loadNews()
                ProfileViewState.SuccessProfileState(news)
           // } catch (e: ServerProblemException) {
              //  Log.i("--STATE", "---------------HttpException: "+e.message)
                //_state.emit(ProfileViewState.ErrorProfileState(e.response.code, e.response.message))
            } catch (e: Throwable) {
                Log.i("--STATE", "---------------Throwable: "+e.message)

                _state.emit(ProfileViewState.ExceptionProfileState(e))
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