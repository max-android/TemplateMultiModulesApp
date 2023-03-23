package com.example.coreUi

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

val LightThemeColorsScheme = lightColorScheme(
    primary = White,

    //primaryVariant = Purple700,
    secondary = Teal200,
    //secondaryVariant = SecondaryVariant,
    background = White,
    surface = White,
    error = LightError,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
    onError = LightError
)

val DarkThemeColorsScheme = darkColorScheme(
    primary = Black,
    //primaryVariant = Purple700,
    secondary = Teal200,
    //secondaryVariant = Gray,
    background = Black,
    surface = Black,
    error = DarkError,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    onError = DarkError
)

@Composable
fun TemplateMultiModulesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkThemeColorsScheme
        else -> LightThemeColorsScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun BaseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightThemeColorsScheme,
        typography = Typography,
        content = content
    )
}