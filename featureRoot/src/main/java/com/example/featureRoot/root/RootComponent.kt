package com.example.featureRoot.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.coreUi.SecondaryVariant
import com.example.coreUi.workComponents.ListShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.beer.BeerModel
import com.example.domain.model.brewery.BreweryModel

@Composable
fun RootComponent(navController: NavController) {
    val viewModel = hiltViewModel<RootViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickBeerItem = { beerId -> },
        onClickBreweryItem = { breweryId -> },
        onClickOpenSite = { url -> }
    )
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickBeerItem: (String) -> Unit,
    onClickBreweryItem: (String) -> Unit,
    onClickOpenSite: (String) -> Unit,
) {
    state?.let { rootState ->
        when (rootState) {
            is LoadingRoot -> {
                ListShimmerComponent()
            }

            is SuccessDataRoot -> {
                ConfigureUi(rootState.beers, rootState.breweries)
            }

            is SuccessError -> {
                LoadError(rootState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ConfigureUi(beers: List<BeerModel>, breweries: List<BreweryModel>) {
    val items = mutableListOf(0, 1)
    LazyColumn() {
        itemsIndexed(items) { index, _ ->
            when (index) {
                0 -> {
                    ConfigureBeer(beers)
                }

                1 -> {
                    ConfigureBrewery(breweries)
                }
            }
        }
    }
}

@Composable
private fun ConfigureBeer(beers: List<BeerModel>) {
    LazyRow(contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)) {
        itemsIndexed(beers) { _, item ->
            BeerItem(item)
        }
    }
}

@Composable
private fun BeerItem(beer: BeerModel) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
            .height(600.dp)
            .width(300.dp)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
    ) {
        AsyncImage(
            modifier = Modifier.weight(1f),
            model = beer.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = beer.name,
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = beer.tips,
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
        }
    }
}

@Composable
private fun ConfigureBrewery(breweries: List<BreweryModel>) {
    LazyRow(contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)) {
        itemsIndexed(breweries) { _, item ->
            BreweryItem(item)
        }
    }
}

@Composable
private fun BreweryItem(brewery: BreweryModel) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
            .height(225.dp)
            .width(300.dp)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = brewery.name,
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = brewery.country,
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
            Text(
                text = brewery.site,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                style = MaterialTheme.typography.labelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}