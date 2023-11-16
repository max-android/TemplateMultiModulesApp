package com.example.navigation

sealed class Screen(val route: String) {
    data object RootScreen: Screen(NavRoute.ROOT_ROUTE)

    data object ShowsScreen: Screen(NavRoute.SHOWS_ROUTE)
    data object ShowsDetailScreen: Screen(NavRoute.SHOWS_DETAIL_ROUTE)
    data object ShowsSeasonsScreen: Screen(NavRoute.SHOWS_SEASONS_DETAIL_ROUTE)
    data object ShowsCrewScreen: Screen(NavRoute.SHOWS_CREW_DETAIL_ROUTE)
    data object ShowsCastScreen: Screen(NavRoute.SHOWS_CAST_DETAIL_ROUTE)
    data object ShowsEpisodesScreen: Screen(NavRoute.SHOWS_EPISODES_ROUTE)
    data object EpisodesDetailScreen: Screen(NavRoute.EPISODES_DETAIL_ROUTE)
    data object EpisodeCrewScreen: Screen(NavRoute.EPISODE_CREW_DETAIL_ROUTE)
    data object EpisodeCastScreen: Screen(NavRoute.EPISODE_CAST_DETAIL_ROUTE)

    data object PeoplesScreen: Screen(NavRoute.PEOPLES_ROUTE)
    data object PeopleDetailScreen: Screen(NavRoute.PEOPLE_DETAIL_ROUTE)
    data object PeopleCharactersScreen: Screen(NavRoute.PEOPLE_CHARACTERS_ROUTE)

    data object OpenScreen: Screen(NavRoute.OPEN_ROUTE)
    data object ArticlesScreen: Screen(NavRoute.ARTICLES_ROUTE)
    data object NewsScreen: Screen(NavRoute.NEWS_ROUTE)
    data object NewsCategoryScreen: Screen(NavRoute.NEWS_CATEGORY_ROUTE)

    data object ProfileScreen: Screen(NavRoute.PROFILE_ROUTE)

    data object PlayersScreen: Screen(NavRoute.PLAYERS_ROUTE)
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