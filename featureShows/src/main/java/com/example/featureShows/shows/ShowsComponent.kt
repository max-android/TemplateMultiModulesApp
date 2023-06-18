package com.example.featureShows.shows

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.Green
import com.example.coreUi.Purple700
import com.example.coreUi.workComponents.ListShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.coreUi.workComponents.EmptyListUi
import com.example.domain.model.shows.ListShowsModel
import com.example.navigation.Screen
import com.example.navigation.KEY_SHOWS_ID
import com.example.navigation.navigateWithBundleSafe

@Composable
fun ShowsComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    Log.i("--STATE", "-------------ShowsComponent")
    val viewModel = hiltViewModel<ShowsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    val context = LocalContext.current
    ObserveState(
        state,
        onClickItem = { showId -> viewModel.obtainEvent(ShowShowsDetailEvent(showId)) },
        onClickEpisodes = { showId ->
            Toast.makeText(context, "Episodes", Toast.LENGTH_SHORT).show()
        },
        onClickSeasons = { showId ->
            Toast.makeText(context, "Seasons", Toast.LENGTH_SHORT).show()
        },
        onClickActors = { showId -> Toast.makeText(context, "Actors", Toast.LENGTH_SHORT).show() },
        onClickCrew = { showId -> Toast.makeText(context, "Crew", Toast.LENGTH_SHORT).show() }
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickItem: (String) -> Unit,
    onClickEpisodes: (String) -> Unit,
    onClickSeasons: (String) -> Unit,
    onClickActors: (String) -> Unit,
    onClickCrew: (String) -> Unit
) {
    state?.let { showsState ->
        when (showsState) {
            is ShowsListSuccess -> {
                Log.i("--STATE", "-------------ShowsComponent ShowsListSuccess")
                ShowsListUi(
                    showsState.listShows,
                    onClickItem,
                    onClickEpisodes,
                    onClickSeasons,
                    onClickActors,
                    onClickCrew
                )
            }
            is ShowsListEmpty -> {
                EmptyListUi()
            }
            is ShowsListLoading -> {
                Log.i("--STATE", "-------------ShowsComponent ShowsListLoading")
                ListShimmerComponent()
            }
            is ShowsListError -> {
                Log.i("--STATE", "-------------ShowsComponent ShowsListError")
                LoadError(showsState.exception)
            }
            else -> {
                Log.i("--STATE", "-------------ShowsComponent ELSE")
            }
        }
    }
}

@Composable
private fun ShowsListUi(
    listShows: List<ListShowsModel>,
    onClickItem: (String) -> Unit,
    onClickEpisodes: (String) -> Unit,
    onClickSeasons: (String) -> Unit,
    onClickActors: (String) -> Unit,
    onClickCrew: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(listShows) { _, item ->
            ShowsListItem(
                item,
                onClickItem,
                onClickEpisodes,
                onClickSeasons,
                onClickActors,
                onClickCrew
            )
        }
    }
}

@Composable
private fun ShowsListItem(
    item: ListShowsModel,
    onClickItem: (String) -> Unit,
    onClickEpisodes: (String) -> Unit,
    onClickSeasons: (String) -> Unit,
    onClickActors: (String) -> Unit,
    onClickCrew: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClickItem.invoke(item.id.toString()) }
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        AsyncImage(
            model = item.mediumImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(225.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(item.name, style = MaterialTheme.typography.labelLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                item.genres.toString(),
                style = MaterialTheme.typography.labelLarge,
                color = Purple700
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .clickable { onClickEpisodes.invoke(item.id.toString()) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.shows_episodes),
                style = MaterialTheme.typography.labelMedium,
                color = Green
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .clickable { onClickSeasons.invoke(item.id.toString()) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.shows_seasons),
                style = MaterialTheme.typography.labelMedium,
                color = Green
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .clickable { onClickActors.invoke(item.id.toString()) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.shows_actors),
                style = MaterialTheme.typography.labelMedium,
                color = Green
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .clickable { onClickCrew.invoke(item.id.toString()) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.shows_crew),
                style = MaterialTheme.typography.labelMedium,
                color = Green
            )
        }
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { showsSideEffect ->
        when (showsSideEffect) {
            is ShowShowsDetailEffect -> {
                Log.i("--STATE", "------------ShowShowsDetailEffect")
                navController.navigateWithBundleSafe(
                    Screen.ShowsDetailScreen.route,
                    bundleOf(KEY_SHOWS_ID to showsSideEffect.showId)
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowsPreview() {
    ShowsListItem(
        ListShowsModel(
            1,
            "https://static.tvmaze.com/uploads/images/medium_portrait/82/206879.jpg",
            "Shows Name sfsdf sdfsdf sdfsdf sdfsdf ",
            listOf("Genre1", "Genre2", "Genre3", "Genre1", "Genre2", "Genre3")
        ),
        {},
        {},
        {},
        {},
        {}
    )
}