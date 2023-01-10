package com.example.featureRoot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.Screen
import com.example.navigation.navigateSafe

@Composable
fun RootComponent(navController: NavController) {
    RootUi(navController)
}

@Composable
private fun RootUi(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                navController.navigateSafe(Screen.ProfileScreen.route)
            },
            modifier = Modifier
                .wrapContentWidth()
                .height(56.dp)
        ) {
            Text(text = "to profile", color = Color.Black)
        }
    }
}