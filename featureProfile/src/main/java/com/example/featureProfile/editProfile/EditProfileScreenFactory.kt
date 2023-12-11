package com.example.featureProfile.editProfile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.ComposeNavFactory
import com.example.navigation.Screen

class EditProfileScreenFactory() : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.EditProfileScreen.route) { navBackStackEntry ->
            EditProfileComponent(navController, navBackStackEntry)
        }
    }

}