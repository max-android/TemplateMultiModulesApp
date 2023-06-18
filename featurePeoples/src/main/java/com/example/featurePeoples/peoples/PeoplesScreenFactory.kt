package com.example.featurePeoples.peoples

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class PeoplesScreenFactory : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.PeoplesScreen.route) { navBackStackEntry ->
            PeoplesComponent(navController, navBackStackEntry)
        }
    }

}