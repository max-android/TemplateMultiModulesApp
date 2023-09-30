package com.example.featureEpisodes.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
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
import com.example.coreUi.SecondaryVariant
import com.example.coreUi.workComponents.EmptyListUi
import com.example.coreUi.workComponents.ListShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.episodes.EpisodesModel
import com.example.navigation.KEY_EPISODE_ID
import com.example.navigation.Screen
import com.example.navigation.navigateWithBundleSafe

@Composable
fun EpisodesComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<EpisodesViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickItem = { episodesId -> viewModel.obtainEvent(ShowEpisodeDetailEvent(episodesId)) },
        onClickCast = { episodesId -> viewModel.obtainEvent(ShowEpisodeCastEvent(episodesId)) },
        onClickCrew = { episodesId -> viewModel.obtainEvent(ShowEpisodeCrewEvent(episodesId)) }
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickItem: (String) -> Unit,
    onClickCast: (String) -> Unit,
    onClickCrew: (String) -> Unit,
) {
    state?.let { showsState ->
        when (showsState) {
            is EpisodesSuccess -> {
                EpisodesUi(
                    showsState.listEpisodes,
                    onClickItem,
                    onClickCast,
                    onClickCrew,
                )
            }

            is EpisodesEmpty -> {
                EmptyListUi()
            }

            is EpisodesLoading -> {
                ListShimmerComponent()
            }

            is EpisodesError -> {
                LoadError(showsState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun EpisodesUi(
    listEpisodes: List<EpisodesModel>,
    onClickItem: (String) -> Unit,
    onClickCast: (String) -> Unit,
    onClickCrew: (String) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(listEpisodes) { _, item ->
            EpisodesItem(
                item,
                onClickItem,
                onClickCast,
                onClickCrew
            )
        }
    }
}

@Composable
private fun EpisodesItem(
    episode: EpisodesModel,
    onClickItem: (String) -> Unit,
    onClickCast: (String) -> Unit,
    onClickCrew: (String) -> Unit,
) {
    Column() {
        EpisodesHeader(episode, onClickItem, onClickCast, onClickCrew)
        EpisodesBody(episode)
    }
}

@Composable
private fun EpisodesHeader(
    episode: EpisodesModel,
    onClickItem: (String) -> Unit,
    onClickCast: (String) -> Unit,
    onClickCrew: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .height(225.dp)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
    ) {
        AsyncImage(
            modifier = Modifier.weight(1f),
            model = episode.mediumImage,
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
                modifier = Modifier
                    .clickable { onClickItem.invoke(episode.id) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.episode_show_detail),
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
            Text(
                modifier = Modifier
                    .clickable { onClickCast.invoke(episode.id) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.episode_show_cast),
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
            Text(
                modifier = Modifier
                    .clickable { onClickCrew.invoke(episode.id) }
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.episode_show_crew),
                style = MaterialTheme.typography.labelMedium,
                color = SecondaryVariant
            )
        }
    }
}

@Composable
private fun EpisodesBody(episode: EpisodesModel) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
            .background(color = Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            model = episode.originalImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = episode.summary,
            style = MaterialTheme.typography.titleMedium,
            color = SecondaryVariant
        )
    }
}


@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { episodesSideEffect ->
        when (episodesSideEffect) {
            is ShowEpisodeDetailEffect -> {
                navController.navigateWithBundleSafe(
                    Screen.EpisodesDetailScreen.route,
                    bundleOf(KEY_EPISODE_ID to episodesSideEffect.episodeId)
                )
            }

            is ShowEpisodesCastEffect -> {
                navController.navigateWithBundleSafe(
                    Screen.EpisodeCastScreen.route,
                    bundleOf(KEY_EPISODE_ID to episodesSideEffect.episodeId)
                )
            }

            is ShowEpisodesCrewEffect -> {
                navController.navigateWithBundleSafe(
                    Screen.EpisodeCrewScreen.route,
                    bundleOf(KEY_EPISODE_ID to episodesSideEffect.episodeId)
                )
            }
        }
    }
}