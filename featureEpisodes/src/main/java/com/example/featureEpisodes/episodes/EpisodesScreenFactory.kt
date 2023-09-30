package com.example.featureEpisodes.episodes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class EpisodesScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ShowsEpisodesScreen.route) { navBackStackEntry ->
            EpisodesComponent(navController, navBackStackEntry)
        }
    }

}