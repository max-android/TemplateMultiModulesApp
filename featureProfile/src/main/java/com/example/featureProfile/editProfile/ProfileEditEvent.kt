package com.example.featureProfile.editProfile

import com.example.common.BaseViewModel

sealed interface ProfileEditEvent : BaseViewModel.BaseEvent
data object InitProfileEvent: ProfileEditEvent
data object UpdateProfileEvent: ProfileEditEvent