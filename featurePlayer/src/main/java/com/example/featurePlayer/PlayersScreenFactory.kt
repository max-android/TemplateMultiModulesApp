package com.example.featurePlayer

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class PlayersScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.PlayersScreen.route) { navBackStackEntry ->
            PlayersComponent(navController, navBackStackEntry)
        }
    }

}