package com.example.featureEpisodes.crewEpisode

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class EpisodeCrewScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.EpisodeCrewScreen.route) { navBackStackEntry ->
            EpisodeCrewComponent(navController, navBackStackEntry)
        }
    }

}