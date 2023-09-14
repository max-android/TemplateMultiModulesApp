package com.example.featureShows.crewShows

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.shows.CrewModel

@Composable
fun ShowsCrewComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<ShowsCrewViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(state)
}

@Composable
private fun ObserveState(state: BaseViewModel.BaseViewState?) {
    state?.let { crewState ->
        when (crewState) {
            is ShowsCrewSuccess -> {
                ShowsCrewUi(crewState.listCrew)
            }

            is ShowsCrewLoading -> {
                DetailShimmerComponent()
            }

            is ShowsCrewError -> {
                LoadError(crewState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ShowsCrewUi(listCrew: List<CrewModel>) {

}