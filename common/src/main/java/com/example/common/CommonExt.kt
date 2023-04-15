package com.example.common

import android.content.res.Resources
import androidx.compose.ui.platform.LocalUriHandler
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

fun Double?.double(): Double {
    return this ?: 0.0
}

fun Float?.float(): Float {
    return this ?: 0.0f
}

fun Int?.int(): Int {
    return this ?: 0
}

fun Boolean?.boolean(): Boolean {
    return this ?: false
}

fun Long?.long(): Long {
    return this ?: 0L
}


