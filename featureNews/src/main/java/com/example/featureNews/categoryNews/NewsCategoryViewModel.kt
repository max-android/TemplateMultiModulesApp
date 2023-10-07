package com.example.featureNews.categoryNews

import com.example.common.BaseViewModel
import com.example.domain.interactor.NewsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsCategoryViewModel @Inject constructor(
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