package com.example.featureProfile

import com.example.domain.model.NewsModel
import com.example.domain.model.ProfileModel

sealed class ProfileViewState {
    class SuccessProfileState(val list: List<NewsModel>): ProfileViewState()
    class ErrorProfileState(val code: Int, val message: String?): ProfileViewState()
    class ExceptionProfileState(val throwable: Throwable): ProfileViewState()
}
