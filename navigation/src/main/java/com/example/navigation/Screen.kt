package com.example.navigation

sealed class Screen(val route: String) {
    object RootScreen: Screen(NavRoute.ROOT_ROUTE)

    object ShowsScreen: Screen(NavRoute.SHOWS_ROUTE)
    object ShowsDetailScreen: Screen(NavRoute.SHOWS_DETAIL_ROUTE)

    object PeoplesScreen: Screen(NavRoute.PEOPLES_ROUTE)
    object PeopleDetailScreen: Screen(NavRoute.PEOPLE_DETAIL_ROUTE)
    object PeopleCharactersScreen: Screen(NavRoute.PEOPLE_CHARACTERS_ROUTE)

    object QuoteScreen: Screen(NavRoute.QUOTE_ROUTE)
    object ArticlesScreen: Screen(NavRoute.ARTICLES_ROUTE)




    //TODO удалить после разработки пары модулей
    object ProfileScreen: Screen(NavRoute.PROFILE_ROUTE)
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