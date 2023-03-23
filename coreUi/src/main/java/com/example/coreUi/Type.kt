package com.example.coreUi

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.coreUi.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MEDIUM,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

//@Composable
//fun typography() = androidx.compose.material.Typography(
//    h1 = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_bold).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 36.sp
//    ),
//    h2 = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_bold).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 28.sp
//    ),
//    subtitle1 = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_semi_bold).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 21.sp
//    ),
//    subtitle2 = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_semi_bold).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//    body1 = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_medium).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 21.sp
//    ),
//    body2 = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_medium).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//    button = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_bold).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//    caption = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_regular).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp
//    ),
//    overline = TextStyle(
//        color = MaterialTheme.colors.onSecondary,
//        fontFamily = Font(R.font.montserrat_regular).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    ),
//    h6 = TextStyle(
//        color = MaterialTheme.colors.error,
//        fontFamily = Font(R.font.montserrat_regular).toFontFamily(),
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    )
//
//)