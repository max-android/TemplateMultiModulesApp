package com.example.featureEpisodes.crewEpisode

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError

@Composable
fun EpisodeCrewComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<EpisodeCrewViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(state)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?
) {
    state?.let { episodeState ->
        when (episodeState) {
            is EpisodeCrewSuccess -> {

            }

            is EpisodeCrewLoading -> {
                DetailShimmerComponent()
            }

            is EpisodeCrewError -> {
                LoadError(episodeState.exception)
            }

            else -> {
            }
        }
    }
}