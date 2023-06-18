package com.example.featurePeoples.characters

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class PeopleCharactersScreenFactory : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.PeopleCharactersScreen.route) { navBackStackEntry ->
            PeopleCharactersComponent(navController, navBackStackEntry)
        }
    }
}