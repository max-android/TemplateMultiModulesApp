package com.example.featureNews.news

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.NewsModel

sealed class NewsState: BaseViewModel.BaseViewState
@Immutable
data class NewsSuccess(val news: List<NewsModel>): NewsState()
data object NewsLoading: NewsState()
data class NewsError(val exception: Throwable): NewsState()