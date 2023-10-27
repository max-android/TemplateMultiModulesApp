package com.example.featureRoot

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.interactor.BeerInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    private val beerInteractor: BeerInteractor
) : BaseViewModel() {


    override fun obtainEvent(event: BaseEvent?) {

    }

    fun doRequest() {

        viewModelScope.launch {
            //beerInteractor.allBeer()
            //beerInteractor.detailBeer("1")
        }
    }

}