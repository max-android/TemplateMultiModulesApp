package com.example.featureShows.detailShows

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.shows.ShowModel

@Composable
fun ShowsDetailComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    Log.i("--STATE", "-------------DetailComponent ")
    val viewModel = hiltViewModel<ShowsDetailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickSiteItem = { urlSite -> viewModel.obtainEvent(ShowSiteShowsEvent(urlSite)) }
    )
    ObserveSideEffect(sideEffect)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickSiteItem: (String) -> Unit
) {
    state?.let { showsState ->
        when (showsState) {
            is ShowsDetailSuccess -> {
                Log.i("--STATE", "------------DetailComponent-ShowsDetailUi ")
                ShowsDetailUi(showsState.showModel, onClickSiteItem)
            }

            is ShowsDetailLoading -> {
                Log.i("--STATE", "------------DetailComponent-ShowsDetailLoading ")
                DetailShimmerComponent()
            }

            is ShowsDetailError -> {
                Log.i("--STATE", "------------DetailComponent-ShowsDetailError ")
                LoadError(showsState.exception)
            }

            else -> {
                Log.i("--STATE", "------------DetailComponent-ELSE")
            }
        }
    }
}

@Composable
private fun ShowsDetailUi(item: ShowModel, onClickSiteItem: (String) -> Unit) {

    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxWidth()
            .verticalScroll(scrollState),
    ) {
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
            text = item.name,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = item.genres.toString(),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.shows_start),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.premiered,
                modifier = Modifier.wrapContentSize().padding(start = 4.dp).align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.shows_end),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.ended,
                modifier = Modifier.wrapContentSize().padding(start = 4.dp).align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.shows_site),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.officialSite,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 4.dp, end = 16.dp)
                    .align(Alignment.Bottom)
                    .clickable { onClickSiteItem.invoke(item.officialSite) },
                style = MaterialTheme.typography.labelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.shows_rating),
                modifier = Modifier.wrapContentSize().padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.rating,
                modifier = Modifier.wrapContentSize().padding(start = 4.dp).align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Text(
            text = item.summary,
            color = colorResource(id = R.color.purple_700),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.wrapContentSize().padding(16.dp),
        )

    }


}

@Composable
private fun ObserveSideEffect(sideEffect: BaseViewModel.BaseSideEffect?) {
    sideEffect?.let { showsSideEffect ->
        when (showsSideEffect) {
            is ShowSiteShowsEffect -> {
                OpenWeb(showsSideEffect.url)
            }
        }
    }
}