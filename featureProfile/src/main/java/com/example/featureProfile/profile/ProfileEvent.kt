package com.example.featureProfile.profile

import com.example.common.BaseViewModel

sealed interface ProfileEvent : BaseViewModel.BaseEvent
data object ProfileEditEvent: ProfileEvent