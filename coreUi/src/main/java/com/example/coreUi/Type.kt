package com.example.coreUi

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// TODO корректировка в будущем
//https://dev.to/vtsen/convert-android-app-to-use-material-3-design-3ojm

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = Black
    ),
    titleMedium = TextStyle(
        fontFamily = SEMI_BOLD,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        color = Black
    ),
    headlineMedium = TextStyle(
        fontFamily = MEDIUM,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp,
        color = Black
    ),
    bodyLarge = TextStyle(
        fontFamily = REGULAR,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Black
    ),
    bodyMedium = TextStyle(
        fontFamily = REGULAR,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp,
        color = Black
    ),
    bodySmall = TextStyle(
        fontFamily = REGULAR,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.5.sp,
        color = Black
    ),
    labelLarge = TextStyle(
        fontFamily = MEDIUM,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Black
    ),
    labelSmall = TextStyle(
        fontFamily = MEDIUM,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.5.sp,
        color = Black
    )
)