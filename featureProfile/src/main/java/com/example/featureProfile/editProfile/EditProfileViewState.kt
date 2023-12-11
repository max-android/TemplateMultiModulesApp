package com.example.featureProfile.editProfile

import com.example.common.BaseViewModel
import com.example.domain.model.ProfileModel

sealed class EditProfileViewState: BaseViewModel.BaseViewState
data class SuccessInitProfileState(val profileModel: ProfileModel): EditProfileViewState()
class ErrorEditProfileState(val exception: Throwable): EditProfileViewState()