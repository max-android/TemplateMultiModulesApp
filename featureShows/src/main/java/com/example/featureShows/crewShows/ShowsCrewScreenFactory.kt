package com.example.featureShows.crewShows

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class ShowsCrewScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ShowsCrewScreen.route) { navBackStackEntry ->
            ShowsCrewComponent(navController, navBackStackEntry)
        }
    }
}