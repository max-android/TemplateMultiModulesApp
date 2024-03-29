package com.example.featureArticles

import com.example.common.BaseViewModel

sealed interface ArticlesSideEffect: BaseViewModel.BaseSideEffect
data object NewsEffect: ArticlesSideEffect
data object PlayersEffect: ArticlesSideEffect
data object ProfileEffect: ArticlesSideEffect