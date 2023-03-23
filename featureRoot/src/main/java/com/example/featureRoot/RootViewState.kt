package com.example.featureRoot

import com.example.common.BaseViewModel

sealed interface RootViewState: BaseViewModel.BaseViewState {
    @JvmInline
    value class SuccessRoot(val isDarkTheme: Boolean): RootViewState
    object SuccessError: RootViewState
}