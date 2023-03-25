package com.example.coreUi.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import com.example.common.standardLog

@Composable
fun SampleState() {
    var counter by remember { mutableStateOf(0) }
    standardLog(currentRecomposeScope, "SampleState")

    Button(
        onClick = { counter++ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            //text = "Clicks: $counterValue",
            text = "Clicks: $counter",
            //modifier = Modifier.clickable(onClick = onCounterClick)
        )
    }


//    SampleCounter(
//        counter = counter,
//        onCounterClick = {
//            counter++
//        }
//    )
}

@Composable
private fun SampleCounter(
    counter: Int,
    onCounterClick: () -> Unit
) {
    standardLog(currentRecomposeScope, "SampleCounter")
    //val counterValue = counter.value
    Button(
        onClick = onCounterClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            //text = "Clicks: $counterValue",
            text = "Clicks: $counter",
            //modifier = Modifier.clickable(onClick = onCounterClick)
        )
    }
}

@Preview
@Composable
fun SampleStatePreview() {
    SampleState()
}