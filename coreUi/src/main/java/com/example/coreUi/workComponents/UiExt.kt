package com.example.coreUi.workComponents

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun BackPressHandler(onBackPressed: () -> Unit, enabled: Boolean = false) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    val callback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                onBackPressed.invoke()
            }
        }
    }

    DisposableEffect(key1 = dispatcher, effect = {
        dispatcher?.addCallback(callback)
        onDispose {
            callback.remove()
        }
    })

}

@Composable
fun LifeComponent(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onResume: () -> Unit,
    onStop: () -> Unit,
    onCreate: () -> Unit,
    onDestroy: () -> Unit,
) {
    // Safely update the current lambdas when a new one is provided
//    val currentOnStart = rememberUpdatedState(onStart)
//    val currentOnStop = rememberUpdatedState(onStop)

    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    //currentOnStart.value.invoke()
                    onResume.invoke()
                }
                Lifecycle.Event.ON_STOP -> {
                    // currentOnStop.value.invoke()
                    onStop.invoke()
                }
                Lifecycle.Event.ON_CREATE -> {
                    // currentOnStop.value.invoke()
                    onCreate.invoke()
                }
                Lifecycle.Event.ON_DESTROY -> {
                    // currentOnStop.value.invoke()
                    onDestroy.invoke()
                }
                else -> {

                }
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

}