package com.example.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.common.R

data class BottomNavItem(
    val screen: Screen,
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int,
    val badgeCount: Int = 0
)

val bottomNavItems = listOf(
    BottomNavItem(
        screen = Screen.RootScreen,
        titleResId = R.string.home,
        drawableResId = R.drawable.ic_home,
        badgeCount = 20
    ),
    BottomNavItem(
        screen = Screen.ShowsScreen,
        titleResId = R.string.shows,
        drawableResId = R.drawable.ic_shows
    ),
    BottomNavItem(
        screen = Screen.PeoplesScreen,
        titleResId = R.string.peoples,
        drawableResId = R.drawable.ic_peoples
    ),
    BottomNavItem(
        screen = Screen.OpenScreen,
        titleResId = R.string.quotes,
        drawableResId = R.drawable.ic_quote
    ),
    BottomNavItem(
        screen = Screen.ArticlesScreen,
        titleResId = R.string.articles,
        drawableResId = R.drawable.ic_article
    )
)