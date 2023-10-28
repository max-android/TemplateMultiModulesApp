package com.example.featureProfile

import com.example.common.BaseViewModel

sealed class ProfileSideEffect: BaseViewModel.BaseSideEffect {
    data object ShowToast: ProfileSideEffect()
    data object ShowOtherScreen: ProfileSideEffect()
}