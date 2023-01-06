package com.example.navigation

sealed class Screen(val route: String) {
    object RootScreen: Screen(NavRoute.ROOT_ROUTE)
    object ProfileScreen: Screen(NavRoute.PROFILE_ROUTE)

}