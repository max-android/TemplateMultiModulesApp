package com.example.featureRoot

import com.example.common.BaseViewModel

sealed interface RootViewState: BaseViewModel.BaseViewState {
    @JvmInline
    value class SuccessRoot(val isDarkTheme: Boolean): RootViewState
    class SuccessError(val exception: Throwable): RootViewState
    class SuccessDataRoot(): RootViewState
}