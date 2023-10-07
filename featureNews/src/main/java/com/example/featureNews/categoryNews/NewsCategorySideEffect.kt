package com.example.featureNews.categoryNews

import com.example.common.BaseViewModel

sealed interface NewsCategorySideEffect: BaseViewModel.BaseSideEffect
@JvmInline
value class NewsCategoryEffect(val category: String): NewsCategorySideEffect