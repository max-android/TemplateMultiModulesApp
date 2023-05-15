package com.example.featureShows.detailShows

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.interactor.ShowsInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.navigation.KEY_SHOWS_ID
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ShowsDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        val showsId = savedStateHandle.get<String>(KEY_SHOWS_ID).orEmpty()
        viewModelScope.launch {
            val state = showsInteractor.detailShow(showsId)
            //(state as ResultState.Success).data.summary
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }
}