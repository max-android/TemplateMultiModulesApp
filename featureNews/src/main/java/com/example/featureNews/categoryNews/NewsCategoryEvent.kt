package com.example.featureNews.categoryNews

import com.example.common.BaseViewModel

sealed interface NewsCategoryEvent: BaseViewModel.BaseEvent
@JvmInline
value class ShowNewsEvent(val category: String): NewsCategoryEvent