package com.example.featureRoot

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.interactor.BeerInteractor
import com.example.domain.interactor.BreweryInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    private val beerInteractor: BeerInteractor,
    private val breweryInteractor: BreweryInteractor
) : BaseViewModel() {


    override fun obtainEvent(event: BaseEvent?) {

    }

    fun doRequest() {
        viewModelScope.launch {
            breweryInteractor.breweries()
            breweryInteractor.searchBreweries("Brewing")
            //beerInteractor.allBeer()
            //beerInteractor.detailBeer("1")
        }
    }

}