package com.example.featurePeoples.detailPeoples

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class PeopleDetailScreenFactory: ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.PeopleDetailScreen.route) { navBackStackEntry ->
            PeopleDetailComponent(navController, navBackStackEntry)
        }
    }

}