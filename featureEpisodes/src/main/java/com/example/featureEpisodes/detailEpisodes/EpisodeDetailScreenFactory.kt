package com.example.featureEpisodes.detailEpisodes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class EpisodeDetailScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.EpisodesDetailScreen.route) { navBackStackEntry ->
            EpisodeDetailComponent(navController, navBackStackEntry)
        }
    }

}