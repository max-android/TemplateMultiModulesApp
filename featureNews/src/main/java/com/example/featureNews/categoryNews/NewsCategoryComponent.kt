package com.example.featureNews.categoryNews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun NewsCategoryComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<NewsCategoryViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
//    ObserveState(
//        state,
//        onClickNewsItem = { category -> viewModel.obtainEvent(ShowNewsEvent) }
//    )
//    ObserveSideEffect(sideEffect, navController)
}