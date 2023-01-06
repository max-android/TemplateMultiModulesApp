package com.example.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigator
import com.example.common.slashEquality

fun NavController.navigateSafe(
    route: String,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    if (currentDestination?.route != route && slashEquality(
            currentDestination?.route.orEmpty(),
            route
        )
    ) {
        navigate(route, navOptions, navExtras)
    }
}

fun NavController.navigateSafeWithBuilder(
    route: String,
    builder: NavOptionsBuilder.() -> Unit
) {
    if (currentDestination?.route != route && slashEquality(
            currentDestination?.route.orEmpty(),
            route
        )
    ) {
        navigate(route, builder)
    }
}