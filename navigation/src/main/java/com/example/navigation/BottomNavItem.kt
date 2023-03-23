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
        screen = Screen.GalleryScreen,
        titleResId = R.string.gallery,
        drawableResId = R.drawable.ic_gallery
    ),
    BottomNavItem(
        screen = Screen.ProfileScreen,
        titleResId = R.string.profile,
        drawableResId = R.drawable.ic_profile
    )
)