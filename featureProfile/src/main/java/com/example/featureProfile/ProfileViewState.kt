package com.example.featureProfile

import com.example.domain.ProfileModel

sealed class ProfileViewState {
    class SuccessProfileState(val profileModel: ProfileModel): ProfileViewState()
    class ErrorProfileState(): ProfileViewState()
}
