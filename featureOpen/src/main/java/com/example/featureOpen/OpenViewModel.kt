package com.example.featureOpen

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.OpenCollectiveInteractor
import com.example.domain.model.openCollective.MemberModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.common.LOAD_COUNT

@HiltViewModel
class OpenViewModel @Inject constructor(
    private val openCollectiveInteractor: OpenCollectiveInteractor,
) : BaseViewModel() {

    private var loadedCount = 0
    var lastPage = false
    var isLoading = false
    private var currentData = emptyList<MemberModel>()

    init {
        loadData(loadedCount)
    }

    private fun loadData(skip: Int, isPaging: Boolean = false) {
        viewModelScope.launch {
            if (!isPaging) {
                sendState(OpenListLoading)
            }
            isLoading = true
            when (val state = openCollectiveInteractor.members(LOAD_COUNT, skip)) {
                is ResultState.Success -> {
                    val pageSize = state.data.size
                    if (pageSize < LOAD_COUNT) {
                        lastPage = true
                    }
                    loadedCount += pageSize
                    isLoading = false
                    currentData = currentData.plus(state.data)
                    sendState(OpenListSuccess(currentData))
                }

                is ResultState.Error -> {
                    sendState(OpenListError(state.exception))
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {
        when (event) {
            is AddOpenList -> {
                if (!lastPage) {
                    loadData(loadedCount, true)
                }
            }

            else -> {}
        }
    }

}