package com.example.featureShows

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.R

@Composable
fun ShowsComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<ShowsViewModel>()
    ShowsUi()
}

@Composable
private fun ShowsUi() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "ShowsUi",
            color = Color.Black,
            fontSize = 36.sp
        )
    }
}