package com.example.featureRoot.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.navigation.*

@Composable
fun BaseRootComponent(screenStarter: ScreenStarter, onDarkModeChanged: (Boolean) -> Unit) {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBarInit(navController)
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
                screenStarter.startOpen().create(this, navController)
                screenStarter.startArticles().create(this, navController)
                screenStarter.startNews().create(this, navController)
                screenStarter.startNewsCategory().create(this, navController)
                screenStarter.startPlayers().create(this, navController)
                /**
                 *  dialog()
                 *  navigation(route = "someRoute", startDestination = "first") {
                 *  composable()
                 *  }
                 */
            }
        }
    )
}

@Composable
private fun BottomBarInit(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    if (isNeedShowBottomBar(navBackStackEntry)) {
        BottomNavigation(
            backgroundColor = Color.Blue,
            elevation = 8.dp
        ) {
            bottomNavItems.forEachIndexed { index, tabBarItem ->
                val isSelected = currentDestination?.hierarchy?.any { destination ->
                    destination.updateSelectedTab(index, tabBarItem)
                } == true
                BottomNavigationItem(
                    modifier = Modifier.background(color = MaterialTheme.colors.secondaryVariant),
                    icon = {
                        BottomBarIcon(tabBarItem)
                    },
                    label = {
                        BottomBarLabel(tabBarItem)
                    },
                    selected = isSelected,
                    selectedContentColor = Color.White,
                    unselectedContentColor = MaterialTheme.colors.primaryVariant,
                    onClick = {
                        navController.navigateSafeWithBuilder(tabBarItem.screen.route) {
                            /**
                             *  Pop up to the start destination of the graph to
                             *  avoid building up a large stack of destinations
                             *  on the back stack as users select items
                             *  popUpTo(navController.graph.findStartDestination().id) {
                             *  saveState = true
                             *  }
                             *
                             */

                            popUpTo(Screen.RootScreen.route) {
                                saveState = true
                            }
                            /**
                             * Avoid multiple copies of the same destination when
                             *  reselecting the same item
                             */
                            launchSingleTop = true
                            /**
                             * Restore state when reselecting a previously selected item
                             * не чистим стек при повторном нажатии таба
                             */
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun BottomBarIcon(tabBarItem: BottomNavItem) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (tabBarItem.badgeCount > 0) {
            BadgedBox(
                badge = {
                    Text(
                        modifier = Modifier
                            .background(
                                Color.Red,
                                shape = CircleShape
                            )
                            .padding(2.dp),
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
    }
}

@Composable
private fun BottomBarLabel(tabBarItem: BottomNavItem) {
    Text(
        stringResource(tabBarItem.titleResId),
        color = MaterialTheme.colors.onPrimary
    )
}