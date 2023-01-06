package com.example.common

fun slashEquality(firstStr: String, secondStr: String): Boolean {
    return firstStr.replaceAfter('/', "") != secondStr.replaceAfter('/', "")
}