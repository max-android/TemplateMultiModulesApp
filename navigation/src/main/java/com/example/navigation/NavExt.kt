package com.example.navigation

import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.*
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

fun NavController.navigateWithBundleSafe(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    if (currentDestination?.route != route && slashEquality(
            currentDestination?.route.orEmpty(),
            route
        )
    ) {
        val routeLink = NavDeepLinkRequest
            .Builder
            .fromUri(NavDestination.createRoute(route).toUri())
            .build()

        val deepLinkMatch = graph.matchDeepLink(routeLink)
        if (deepLinkMatch != null) {
            val destination = deepLinkMatch.destination
            val id = destination.id
            navigate(id, args, navOptions, navigatorExtras)
        } else {
            navigate(route, navOptions, navigatorExtras)
        }
    }
}

fun <T> NavBackStackEntry.parcelableData(key: String): T? {
    return arguments?.getParcelable(key) as? T
}