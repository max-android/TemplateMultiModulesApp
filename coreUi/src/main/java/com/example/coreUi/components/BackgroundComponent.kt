package com.example.coreUi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun doBackground() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .width(160.dp)
            .height(120.dp)
            //.background(color = Color.Blue, shape = RoundedCornerShape(32.dp))
            .background(color = Color.Blue, shape = androidx.compose.foundation.shape.CircleShape)
            .align(Alignment.TopCenter)
        )
        Box(modifier = Modifier
            .width(160.dp)
            .height(120.dp)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.DarkGray,
                        Color.Black,
                        Color.Magenta
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow, Color.Green)),
                alpha = 0.2f,
                shape = RoundedCornerShape(16.dp)
            )
            .align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun doBackground2() {

    Row {
        val focusManager = LocalFocusManager.current
        Column {
            val (a, b, c) = FocusRequester.createRefs()
            TextField(
                modifier = Modifier
                    .focusRequester(a)
                    .focusProperties {
                        next = b
                    },
                value = "",
                onValueChange = {},
            )
            TextField(
                modifier = Modifier
                    .focusRequester(b)
                    .focusProperties {
                        previous = a
                        next = c
                    },
                value = "",
                onValueChange = {},
            )
            TextField(
                modifier = Modifier
                    .focusRequester(c)
                    .focusProperties {
                        previous = b
                    },
                value = "",
                onValueChange = {},
            )
        }
        Column {
            Button(onClick = {
                focusManager.moveFocus(FocusDirection.Previous)
            }) {
                Text("Previous")
            }
            Button(onClick = {
                focusManager.moveFocus(FocusDirection.Next)
            }) {
                Text("Next")
            }
        }
    }
}

@Preview
@Composable
fun BackgroundPreview() {
   // doBackground()
    doBackground2()
}