package com.example.featureProfile.profile

import com.example.common.BaseViewModel

sealed class ProfileSideEffect: BaseViewModel.BaseSideEffect
data object UpdateProfileEffect: ProfileSideEffect()