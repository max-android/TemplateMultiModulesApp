package com.example.featureArticles

import com.example.common.BaseViewModel

sealed class ArticlesState : BaseViewModel.BaseViewState
data object InitArticles : ArticlesState()