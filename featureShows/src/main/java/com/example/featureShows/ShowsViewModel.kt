package com.example.featureShows

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.ShowsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(
    private val showsInteractor: ShowsInteractor,
) : BaseViewModel() {

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            val state = showsInteractor.allShows()
           // val state = showsInteractor.detailShow("1")

            when (state) {
                is ResultState.Success -> {
                }
                else -> {
                    Log.i("--LIST", "--------ERROR")
                }
            }
        }
    }


    override fun obtainEvent(event: BaseEvent?) {

    }


}