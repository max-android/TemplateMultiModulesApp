package com.example.featureShows.detailShows

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class ShowsDetailScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ShowsDetailScreen.route) { navBackStackEntry ->
            ShowsDetailComponent(navController, navBackStackEntry)
        }
    }
}