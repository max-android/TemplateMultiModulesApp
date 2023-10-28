package com.example.featureRoot.root

import androidx.lifecycle.viewModelScope
import com.example.common.BaseViewModel
import com.example.domain.common.ResultState
import com.example.domain.interactor.BeerInteractor
import com.example.domain.interactor.BreweryInteractor
import com.example.domain.model.beer.BeerModel
import com.example.domain.model.brewery.BreweryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    private val beerInteractor: BeerInteractor,
    private val breweryInteractor: BreweryInteractor
) : BaseViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            sendState(LoadingRoot)
            val beersDeferred = async { beerInteractor.allBeer() }
            val breweriesDeferred = async { breweryInteractor.breweries() }
            val beers: ResultState<List<BeerModel>> = beersDeferred.await()
            val breweries: ResultState<List<BreweryModel>> = breweriesDeferred.await()
            if (beers is ResultState.Success && breweries is ResultState.Success) {
                sendState(SuccessDataRoot(beers.data, breweries.data))
            } else {
                when {
                    beers is ResultState.Error -> {
                        sendState(SuccessError(beers.exception))
                    }

                    breweries is ResultState.Error -> {
                        sendState(SuccessError(breweries.exception))
                    }

                    else -> {}
                }
            }
        }
    }

    override fun obtainEvent(event: BaseEvent?) {

    }

}