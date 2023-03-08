package com.example.coreUi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DoImages() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
            contentDescription = null
        )
        
        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth().height(150.dp),
            shape = RoundedCornerShape(21.dp),
            elevation = 8.dp
        ) {
            Box(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize().height(150.dp),
                    model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Text description",
                    color = Color.Green,
                    modifier = Modifier.align(Alignment.BottomStart).padding(24.dp))
            }
        }
    }
    
}

@Preview
@Composable
fun ImagesPreview() {
    DoImages()
}