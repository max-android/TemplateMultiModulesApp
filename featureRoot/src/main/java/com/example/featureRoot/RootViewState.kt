package com.example.featureRoot

import com.example.common.BaseViewModel

sealed class RootViewState: BaseViewModel.BaseViewState {
    object SuccessRoot: RootViewState()
    object SuccessError: RootViewState()
}