package com.example.featureRoot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.LoadError

@Composable
fun RootUi(navController: NavController) {
    val viewModel = hiltViewModel<RootViewModel>()
    viewModel.doRequest()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickItem = { episodesId -> },
        onClickCast = { episodesId -> },
        onClickCrew = { episodesId -> }
    )
    ObserveSideEffect(sideEffect, navController)

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {

                // navController.navigateSafe(Screen.ProfileScreen.route)
                //val nav = NavOptions.Builder().setPopUpTo()
//                navController.navigateWithBundleSafe(
//                   // Screen.ProfileScreen.route, bundleOf("myKey" to 100)
//                    Screen.ProfileScreen.route, bundleOf("myKey" to Person("б4324", "234"))
//                )
            },
            modifier = Modifier
                .wrapContentWidth()
                .height(56.dp)
        ) {
            Text(text = "to profile", color = Color.Black)
        }
    }

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
            is RootViewState.SuccessDataRoot -> {

            }

            is RootViewState.SuccessError -> {
                LoadError(showsState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { rootSideEffect ->
        when (rootSideEffect) {
//            is ShowEpisodeDetailEffect -> {
//                navController.navigateWithBundleSafe(
//                    Screen.EpisodesDetailScreen.route,
//                    bundleOf(KEY_EPISODE_ID to episodesSideEffect.episodeId)
//                )
//            }
//
//            is ShowEpisodesCastEffect -> {
//                navController.navigateWithBundleSafe(
//                    Screen.EpisodeCastScreen.route,
//                    bundleOf(KEY_EPISODE_ID to episodesSideEffect.episodeId)
//                )
//            }
//
//            is ShowEpisodesCrewEffect -> {
//                navController.navigateWithBundleSafe(
//                    Screen.EpisodeCrewScreen.route,
//                    bundleOf(KEY_EPISODE_ID to episodesSideEffect.episodeId)
//                )
//            }
        }
    }
}