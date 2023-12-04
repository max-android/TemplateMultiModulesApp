package com.example.featureProfile.profile

import com.example.common.BaseViewModel

sealed class ProfileViewState: BaseViewModel.BaseViewState
data object SuccessProfileState: ProfileViewState()
class ErrorProfileState(val exception: Throwable): ProfileViewState()