package com.example.featureProfile.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.featureProfile.profile.ProfileComponent
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class ProfileScreenFactory() : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ProfileScreen.route) { navBackStackEntry ->
            ProfileComponent(navController, navBackStackEntry)
        }
    }

}