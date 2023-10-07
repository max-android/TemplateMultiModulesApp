package com.example.featureArticles

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class ArticlesScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ArticlesScreen.route) { navBackStackEntry ->
            ArticlesComponent(navController, navBackStackEntry)
        }
    }
}