package com.example.featureRoot

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavOptions
import androidx.navigation.compose.*
import androidx.navigation.navigation
import com.example.coreUi.components.Person
import com.example.navigation.*

@Composable
fun BaseRootComponent(screenStarter: ScreenStarter, onDarkModeChanged: (Boolean) -> Unit) {
    Log.i("--STATE", "------------BaseRootComponent")
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            if (isNeedShowBottomBar(navBackStackEntry)) {
                BottomNavigation(
                    //backgroundColor = Color.Yellow,
                    elevation = 8.dp
                ) {
                    bottomNavItems.forEachIndexed { index, tabBarItem ->
                        val isSelected = currentDestination?.hierarchy?.any { destination ->
                            destination.updateSelectedTab(index, tabBarItem)
                        } == true
                        BottomNavigationItem(
                            modifier = Modifier.background(color = MaterialTheme.colors.secondaryVariant),
                            icon = {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    if (tabBarItem.badgeCount > 0) {
                                        BadgedBox(
                                            badge = {
                                                    Text(
                                                        modifier = Modifier.background(Color.Red, shape = CircleShape).padding(2.dp),
                                                        text = tabBarItem.badgeCount.toString(),
                                                        fontSize = 8.sp,
                                                    )
                                            }
                                        ) {
                                            Icon(
                                                painter = painterResource(id = tabBarItem.drawableResId),
                                                contentDescription = null,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                    } else {
                                        Icon(
                                            painter = painterResource(id = tabBarItem.drawableResId),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
//                                    if (isSelected) {
//                                        Text(
//                                            stringResource(tabBarItem.titleResId),
//                                            textAlign = TextAlign.Center,
//                                            fontSize = 10.sp
//                                        )
//                                    }
                                }
                            },
                            label = {
                                Text(
                                    stringResource(tabBarItem.titleResId),
                                    color = MaterialTheme.colors.onPrimary
                                )
                            },
                            selected = isSelected,
                            selectedContentColor = Color.White,
                            unselectedContentColor = MaterialTheme.colors.primaryVariant,
                            onClick = {
                                navController.navigateSafeWithBuilder(tabBarItem.screen.route) {
                                    Log.i("--STATE", "------------ROOT---")
//                                        // Pop up to the start destination of the graph to
//                                        // avoid building up a large stack of destinations
//                                        // on the back stack as users select items
//                                        popUpTo(navController.graph.findStartDestination().id) {
//                                            saveState = true
//                                        }
                                    popUpTo(Screen.RootScreen.route) {
                                        saveState = true
                                    }
//                                        // Avoid multiple copies of the same destination when
//                                        // reselecting the same item
                                    launchSingleTop = true

                                    // Restore state when reselecting a previously selected item
                                    // не чистим стек при повторном нажатии таба
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        },
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screen.RootScreen.route,
                Modifier.padding(paddingValues)
            ) {
                screenStarter.startRoot().create(this, navController)
                screenStarter.startProfile().create(this, navController)
                screenStarter.startShows().create(this, navController)
                screenStarter.startShowsDetail().create(this, navController)
                screenStarter.startShowsSeasons().create(this, navController)
                screenStarter.startShowsCast().create(this, navController)
                screenStarter.startShowsCrew().create(this, navController)
                screenStarter.startEpisodes().create(this, navController)
                screenStarter.startEpisodeDetail().create(this, navController)
                screenStarter.startEpisodeCast().create(this, navController)
                screenStarter.startEpisodeCrew().create(this, navController)
                screenStarter.startPeoples().create(this, navController)
                screenStarter.startPeopleDetail().create(this, navController)
                screenStarter.startPeopleCharacters().create(this, navController)
                screenStarter.startQuotes().create(this, navController)
                screenStarter.startArticles().create(this, navController)
                screenStarter.startNews().create(this, navController)
                screenStarter.startNewsCategory().create(this, navController)

                //dialog()
//                navigation(route = "someRoute", startDestination = "first") {
//                    composable()
//                }
            }
        }
    )
}

@Composable
fun RootComponent(navController: NavController) {
    RootUi(navController)
}

@Composable
private fun RootUi(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
               // navController.navigateSafe(Screen.ProfileScreen.route)
                //val nav = NavOptions.Builder().setPopUpTo()
                navController.navigateWithBundleSafe(
                   // Screen.ProfileScreen.route, bundleOf("myKey" to 100)
                    Screen.ProfileScreen.route, bundleOf("myKey" to Person("б4324", "234"))
                )
            },
            modifier = Modifier
                .wrapContentWidth()
                .height(56.dp)
        ) {
            Text(text = "to profile", color = Color.Black)
        }
    }
}