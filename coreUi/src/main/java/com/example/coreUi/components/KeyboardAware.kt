package com.example.coreUi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun KeyboardAware(
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier.imePadding()) {
        content()
    }
}

@Composable
fun SearchSongScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
    ) {

        OutlinedTextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Button(
            onClick = { },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview
@Composable
fun KeyboardPreview() {
   // поднимает кнопку над клавиатурой
    //https://medium.com/@mark.frelih_9464/how-to-handle-automatic-content-resizing-when-keyboard-is-visible-in-jetpack-compose-1c76e0e17c57
    KeyboardAware {
        SearchSongScreen()
    }
}