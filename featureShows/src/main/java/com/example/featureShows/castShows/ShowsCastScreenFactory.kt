package com.example.featureShows.castShows

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class ShowsCastScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ShowsCastScreen.route) { navBackStackEntry ->
            ShowsCastComponent(navController, navBackStackEntry)
        }
    }
}