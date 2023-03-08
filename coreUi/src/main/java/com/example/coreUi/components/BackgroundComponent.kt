package com.example.coreUi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun doBackground() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .width(160.dp).height(120.dp)
            //.background(color = Color.Blue, shape = RoundedCornerShape(32.dp))
            .background(color = Color.Blue, shape = androidx.compose.foundation.shape.CircleShape)
            .align(Alignment.TopCenter)
        )
        Box(modifier = Modifier
            .width(160.dp).height(120.dp)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(colors = listOf(Color.DarkGray, Color.Black, Color.Magenta)),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow, Color.Green)),
                alpha = 0.2f,
                shape = RoundedCornerShape(16.dp)
            ).align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun BackgroundPreview() {
    doBackground()
}