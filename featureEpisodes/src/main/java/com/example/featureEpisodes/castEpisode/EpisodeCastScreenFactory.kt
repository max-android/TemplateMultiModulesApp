package com.example.featureEpisodes.castEpisode

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class EpisodeCastScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.EpisodeCastScreen.route) { navBackStackEntry ->
            EpisodeCastComponent(navController, navBackStackEntry)
        }
    }

}