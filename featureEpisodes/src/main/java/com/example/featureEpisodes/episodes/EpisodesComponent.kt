package com.example.featureEpisodes.episodes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
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