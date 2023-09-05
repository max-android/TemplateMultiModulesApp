package com.example.featureSeasons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.components.OpenWeb
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.EmptyListUi
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.shows.seasons.SeasonsModel

@Composable
fun ShowsSeasonsComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<ShowsSeasonsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickSiteItem = { urlSite -> viewModel.obtainEvent(ShowSiteSeasonsEvent(urlSite)) }
    )
    ObserveSideEffect(sideEffect)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickSiteItem: (String) -> Unit
) {
    state?.let { seasonsState ->
        when (seasonsState) {
            is ShowsSeasonsSuccess -> {
                ShowsSeasonsUi(seasonsState.listSeasons, onClickSiteItem)
            }

            is ShowsSeasonsLoading -> {
                DetailShimmerComponent()
            }

            is ShowsSeasonsError -> {
                LoadError(seasonsState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ShowsSeasonsUi(listSeasons: List<SeasonsModel>, onClickSiteItem: (String) -> Unit) {

    if (listSeasons.isEmpty()) {
        EmptyListUi()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(listSeasons) { _, item ->
                ShowsSeasonsItem(item, onClickSiteItem)
            }
        }
    }

}

@Composable
private fun ShowsSeasonsItem(
    item: SeasonsModel,
    onClickSiteItem: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = item.originalImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = item.name.ifEmpty { stringResource(id = R.string.empty_name) },
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.site,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp, end = 16.dp)
                .clickable { onClickSiteItem.invoke(item.site) },
            style = MaterialTheme.typography.labelLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.premiere_date),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.premiereDate,
                modifier = Modifier.wrapContentSize().padding(start = 4.dp).align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.end_date),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.endDate,
                modifier = Modifier.wrapContentSize().padding(start = 4.dp).align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.summary),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.summary,
                modifier = Modifier.wrapContentSize().padding(start = 4.dp).align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun ObserveSideEffect(sideEffect: BaseViewModel.BaseSideEffect?) {
    sideEffect?.let { seasonsSideEffect ->
        when (seasonsSideEffect) {
            is ShowSiteSeasonsEffect -> {
                OpenWeb(seasonsSideEffect.url)
            }
        }
    }
}