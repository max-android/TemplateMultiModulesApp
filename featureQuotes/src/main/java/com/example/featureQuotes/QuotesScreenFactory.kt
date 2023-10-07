package com.example.featureQuotes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class QuotesScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.QuoteScreen.route) { navBackStackEntry ->
            QuotesComponent(navController, navBackStackEntry)
        }
    }
}