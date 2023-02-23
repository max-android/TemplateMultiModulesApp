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
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.coreUi.components.SampleConstraintLayout
import com.example.navigation.Screen
import com.example.navigation.navigateWithBundleSafe

@Composable
fun RootComponent(navController: NavController) {
    RootUi(navController)
}

@Composable
private fun RootUi(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        SampleConstraintLayout()
        Button(
            onClick = {
               // navController.navigateSafe(Screen.ProfileScreen.route)
                navController.navigateWithBundleSafe(
                    Screen.ProfileScreen.route, bundleOf("myKey" to 100)
                )
            },
            modifier = Modifier
                .wrapContentWidth()
                .height(56.dp)
        ) {
            Text(text = "to profile", color = Color.Black)
        }
    }
}