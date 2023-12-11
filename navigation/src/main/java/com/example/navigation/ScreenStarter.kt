package com.example.navigation

interface ScreenStarter {

    fun startRoot(): ComposeNavFactory

    fun startShows(): ComposeNavFactory

    fun startShowsDetail(): ComposeNavFactory

    fun startShowsSeasons(): ComposeNavFactory

    fun startShowsCrew(): ComposeNavFactory

    fun startShowsCast(): ComposeNavFactory

    fun startEpisodes(): ComposeNavFactory

    fun startEpisodeDetail(): ComposeNavFactory

    fun startEpisodeCrew(): ComposeNavFactory

    fun startEpisodeCast(): ComposeNavFactory

    fun startPeoples(): ComposeNavFactory

    fun startPeopleDetail(): ComposeNavFactory

    fun startPeopleCharacters(): ComposeNavFactory

    fun startOpen(): ComposeNavFactory

    fun startArticles(): ComposeNavFactory

    fun startNews(): ComposeNavFactory

    fun startNewsCategory(): ComposeNavFactory

    fun startProfile(): ComposeNavFactory

    fun startEditProfile(): ComposeNavFactory

    fun startPlayers(): ComposeNavFactory

    fun startTest(): ComposeNavFactory

}
 //Правила:
//1:
//start -> main -> profile -> settings
//
// from profile
// navigate("settings") {
// popUpTo(main)
//
// }
//   Result:
//start -> main -> settings

//2:
//start -> main -> profile -> settings
//
// from profile
// navigate("settings") {
// popUpTo(main) { inclusive = true }
//
// }
//   Result:
//start -> settings

//3:
//launchSingleTop - не дает создавать подобнаый экран сверх текущего: например HOME -> HOME

//4:
//popBackStack()
//popBackStack(route = "main", inclusive = false) удаляем все экраны вплоть до начального

//если inclusive = true чистим и "main" -> попадаем в "start"

//5:
//navController.currentBackStackEntry
//navController.currentBackStackEntryAsState() внутри @Composable функции

//6
//разбивка на графы по фиче, если есть экраны - которые тока внутри фичи






