package com.example.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface ComposeNavFactory {
    fun create(navGraphBuilder: NavGraphBuilder, navController: NavController)
}