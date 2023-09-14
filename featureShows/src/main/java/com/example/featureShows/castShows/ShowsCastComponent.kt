package com.example.featureShows.castShows

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.shows.CastModel

@Composable
fun ShowsCastComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<ShowsCastViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(state)
}

@Composable
private fun ObserveState(state: BaseViewModel.BaseViewState?) {
    state?.let { crewState ->
        when (crewState) {
            is ShowsCastSuccess -> {
                ShowsCastUi(crewState.listCrew)
            }

            is ShowsCastLoading -> {
                DetailShimmerComponent()
            }

            is ShowsCastError -> {
                LoadError(crewState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ShowsCastUi(listCast: List<CastModel>) {

}