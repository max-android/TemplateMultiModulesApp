package com.example.navigation

sealed class Screen(val route: String) {
    object RootScreen: Screen(NavRoute.ROOT_ROUTE)
    object ProfileScreen: Screen(NavRoute.PROFILE_ROUTE)

    //TODO заменить или реализовать
    object GalleryScreen: Screen(NavRoute.GALLERY_ROUTE)

}

//// Pop everything up to the "home" destination off the back stack before
//// navigating to the "friendslist" destination
//navController.navigate("friendslist") {
//    popUpTo("home")
//}
//
//// Pop everything up to and including the "home" destination off
//// the back stack before navigating to the "friendslist" destination
//navController.navigate("friendslist") {
//    popUpTo("home") { inclusive = true }
//}
//
//// Navigate to the "search” destination only if we’re not already on
//// the "search" destination, avoiding multiple copies on the top of the
//// back stack
//navController.navigate("search") {
//    launchSingleTop = true
//}