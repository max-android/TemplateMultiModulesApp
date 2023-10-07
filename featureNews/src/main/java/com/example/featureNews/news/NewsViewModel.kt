package com.example.featureNews.news

import com.example.common.BaseViewModel
import com.example.domain.interactor.NewsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsInteractor: NewsInteractor
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {

    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}