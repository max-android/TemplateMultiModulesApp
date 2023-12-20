package com.example.featureArticles.test

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleEventObserver
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.domain.model.shows.ListShowsModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Composable
fun DifferentComponent() {

//    val lifecycle = LocalLifecycleOwner.current
//    LaunchedEffect(key1 = true, block = {
//        val observer = LifecycleEventObserver { _, event ->
//            // Log.i("--LIFE", "------------event1:"+event)
//        }
//
//        lifecycle.lifecycle.addObserver(observer)
//    })


//    var counter = remember {
//        mutableIntStateOf(0)
//    }
//
//    val counterText = remember {
//        derivedStateOf {
//            "The conter is${counter.intValue}"
//        }
//    }
//
//    LaunchedEffect(key1 = true, block ={
//        snapshotFlow {
//            counter.intValue
//        }.filter { i ->
//            i%2 == 0
//        }.distinctUntilChanged().collect {
//            Log.i("--Flow", "------------:" + it)
//        }
//    })

    DisposableEffect(true) {
        onDispose {
            Log.i("--LIFE", "------------exit")
        }
    }

//    Button(
//        onClick = { counter.intValue++ },
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        androidx.compose.material.Text(
//            text = "Clicks: ${counterText.value}",
//        )
//    }

    var counter = remember {
        mutableIntStateOf(0)
    }

    Button(
        onClick = {

        },
        modifier = Modifier.fillMaxWidth()
    ) {
        androidx.compose.material.Text(
            text = "Clicks: ${counter.value}",
        )
    }

}

@Preview
@Composable
fun ShowsPreview() {
    DifferentComponent()
}