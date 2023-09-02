package com.example.featureSeasons

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class ShowsSeasonsScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ShowsSeasonsScreen.route) { navBackStackEntry ->
            ShowsSeasonsComponent(navController, navBackStackEntry)
        }
    }
}