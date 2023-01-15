package com.example.featureProfile

import com.example.common.BaseViewModel

sealed class ProfileSideEffect: BaseViewModel.BaseSideEffect {
    object ShowToast: ProfileSideEffect()
    object ShowOtherScreen: ProfileSideEffect()
}