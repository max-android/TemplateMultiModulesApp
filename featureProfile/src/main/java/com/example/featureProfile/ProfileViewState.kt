package com.example.featureProfile

import com.example.common.BaseViewModel
import com.example.domain.model.NewsModel

sealed class ProfileViewState: BaseViewModel.BaseViewState {
    class SuccessProfileState(val list: List<NewsModel>): ProfileViewState()
    class ErrorProfileState(val code: Int, val message: String?): ProfileViewState()
    class ExceptionProfileState(val throwable: Throwable): ProfileViewState()
}
