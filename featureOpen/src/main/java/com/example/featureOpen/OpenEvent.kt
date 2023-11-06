package com.example.featureOpen

import com.example.common.BaseViewModel

sealed interface OpenEvent: BaseViewModel.BaseEvent
data object AddOpenList: OpenEvent