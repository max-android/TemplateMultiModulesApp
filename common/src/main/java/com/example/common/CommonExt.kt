package com.example.common

import android.content.res.Resources
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.system.measureTimeMillis

fun slashEquality(firstStr: String, secondStr: String): Boolean {
    return firstStr.replaceAfter('/', "") != secondStr.replaceAfter('/', "")
}

fun doMeasurement(process: () -> Unit): Long {
    return measureTimeMillis {
        process.invoke()
    }
}

fun Float.toDp(): Dp {
    return (this / Resources.getSystem().displayMetrics.density).dp
}