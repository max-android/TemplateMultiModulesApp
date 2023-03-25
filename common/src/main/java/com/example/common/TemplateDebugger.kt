package com.example.common

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RecomposeScope
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.remember

fun standardLog(recomposeScope: RecomposeScope, marker: String = EMPTY_VALUE) {
    Log.d("DebugRecomposition", "$marker :$recomposeScope")
}

//class RecompositionCounter(var value: Int)
//
//@Composable
// inline fun LogCompositions(tag: String, msg: String) {
//    val recompositionCounter = remember { RecompositionCounter(0) }
//    Log.d(tag, "$msg ${recompositionCounter.value} $currentRecomposeScope")
//    recompositionCounter.value++
//}