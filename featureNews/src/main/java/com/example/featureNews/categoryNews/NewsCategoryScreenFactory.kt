package com.example.featureNews.categoryNews

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class NewsCategoryScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.NewsCategoryScreen.route) { navBackStackEntry ->
            NewsCategoryComponent(navController, navBackStackEntry)
        }
    }
}