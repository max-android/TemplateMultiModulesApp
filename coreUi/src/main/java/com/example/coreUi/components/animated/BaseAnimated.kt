package com.example.coreUi.components.animated

import androidx.compose.animation.*
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedUi() {

    Column(modifier = Modifier.fillMaxSize()
        .animateContentSize()
    ) {

        var visibleState by remember {
            mutableStateOf(false)
        }

        var isRound by remember {
            mutableStateOf(false)
        }

        Button(onClick = {
            visibleState = !visibleState
            isRound = !isRound
        }) {
            Text("animated")
        }


        val borderRadius = animateIntAsState(
            targetValue = if (isRound) 100 else 0,
            animationSpec = tween(
                durationMillis = 3000,
                delayMillis = 1000
            )

        )

        val transition = updateTransition(
            targetState = isRound,
            label = null
        )

        val borderRadiusInt = transition.animateInt(
            transitionSpec = { tween(2000) },
            label = "",
            targetValueByState = { round ->
                if (round) 100 else 0
            }
        )
        val borderRadiusColor = transition.animateColor(
            transitionSpec = { tween(2000) },
            label = "",
            targetValueByState = { round ->
                if (round) Color.Green else Color.Red
            }
        )

//        Box(modifier = Modifier
//            .size(200.dp)
//            .clip(RoundedCornerShape(borderRadiusInt.value))
//            .background(borderRadiusColor.value)) {
//
//        }


//        Box(modifier = Modifier.size(200.dp)
//            .clip(RoundedCornerShape(borderRadius.value))
//            .background(Color.Red)) {
//
//        }



//        AnimatedVisibility(
//            visible = visibleState,
//            enter = slideInHorizontally() + fadeIn(),
//            modifier = Modifier.fillMaxWidth().weight(1f)
//        ) {
//            Box(modifier = Modifier.background(Color.Blue))
//        }

        if (visibleState) {
            Text(
                text = "Consider a TextView that displays a static title using android:text=\"@string/title\", as defined in a layout XML file. When the view is created, it sets the text exactly once, based on the current language. If the language changes, the system recreates the activity. Consequently, the system also recreates the view and initializes it to the correct value based on the new language.\n" +
                        "\n" +
                        "The recreation also clears out any state you have kept as fields in the Activity, or in any of its contained Fragments, Views, and other objects. This is because Activity recreation creates a completely new instance of the Activity and the UI. Furthermore, the old Activity is no longer visible or valid, so any remaining references to it or its contained objects are stale. They may cause bugs, memory leaks, and crashes."
            )
        }




    }

}