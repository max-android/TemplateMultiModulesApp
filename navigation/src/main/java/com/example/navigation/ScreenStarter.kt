package com.example.navigation

interface ScreenStarter {

    fun startRoot(): ComposeNavFactory

    fun startShows(): ComposeNavFactory



    //TODO удалить после разработки пары модулей
    fun startProfile(): ComposeNavFactory

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






