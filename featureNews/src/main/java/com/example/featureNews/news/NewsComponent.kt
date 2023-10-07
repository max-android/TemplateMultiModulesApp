package com.example.featureNews.news

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun NewsComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<NewsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
//    ObserveState(
//        state,
//        onClickNewsItem = { category -> viewModel.obtainEvent(ShowNewsEvent) }
//    )
//    ObserveSideEffect(sideEffect, navController)
}




