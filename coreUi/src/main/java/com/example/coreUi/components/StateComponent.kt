package com.example.coreUi.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*

@Composable
fun SampleState() {
    var counter by remember { mutableStateOf(0) }
    SampleCounter(
        counter = counter,
        onCounterClick = {
            counter++
        }
    )
}

@Composable
private fun SampleCounter(
    counter: Int,
    onCounterClick: () -> Unit
) {
    //val counterValue = counter.value
    Text(
        //text = "Clicks: $counterValue",
        text = "Clicks: $counter",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
}

@Preview
@Composable
fun SampleStatePreview() {
    SampleState()
}