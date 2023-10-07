package com.example.featureNews.categoryNews

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel

sealed class NewsCategoryState: BaseViewModel.BaseViewState
@Immutable
data class NewsCategorySuccess(val categories: List<String>): NewsCategoryState()
data object NewsCategoryLoading: NewsCategoryState()