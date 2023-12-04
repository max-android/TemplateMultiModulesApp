package com.example.featureArticles

import com.example.common.BaseViewModel

sealed interface ArticlesEvent: BaseViewModel.BaseEvent
data object ShowNewsEvent: ArticlesEvent
data object ShowPlayersEvent: ArticlesEvent
data object ShowProfileEvent: ArticlesEvent