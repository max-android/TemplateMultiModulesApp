package com.example.featureRoot.root

import androidx.compose.runtime.Immutable
import com.example.common.BaseViewModel
import com.example.domain.model.beer.BeerModel
import com.example.domain.model.brewery.BreweryModel

sealed interface RootViewState : BaseViewModel.BaseViewState
@JvmInline
value class SuccessRoot(val isDarkTheme: Boolean) : RootViewState
class SuccessError(val exception: Throwable) : RootViewState
@Immutable
class SuccessDataRoot(
    val beers: List<BeerModel>,
    val breweries: List<BreweryModel>
) : RootViewState

data object LoadingRoot : RootViewState