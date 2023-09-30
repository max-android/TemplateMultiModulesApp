package com.example.featureEpisodes.castEpisode

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
fun EpisodeCastComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<EpisodeCastViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(state)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?
) {
    state?.let { episodeState ->
        when (episodeState) {
            is EpisodeCastSuccess -> {

            }

            is EpisodeCastLoading -> {
                DetailShimmerComponent()
            }

            is EpisodeCastError -> {
                LoadError(episodeState.exception)
            }

            else -> {
            }
        }
    }
}