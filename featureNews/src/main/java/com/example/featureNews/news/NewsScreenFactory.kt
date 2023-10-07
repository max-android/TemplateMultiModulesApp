package com.example.featureNews.news

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.featureNews.news.NewsComponent
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class NewsScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.NewsScreen.route) { navBackStackEntry ->
            NewsComponent(navController, navBackStackEntry)
        }
    }
}