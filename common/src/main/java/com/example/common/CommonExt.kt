package com.example.common

import kotlin.system.measureTimeMillis

fun slashEquality(firstStr: String, secondStr: String): Boolean {
    return firstStr.replaceAfter('/', "") != secondStr.replaceAfter('/', "")
}

fun doMeasurement(process: () -> Unit): Long {
    return measureTimeMillis {
        process.invoke()
    }
}