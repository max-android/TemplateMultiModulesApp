package com.example.featureArticles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.coreUi.components.readyUi.FilledTonalButtonWithIcon
import com.example.navigation.Screen
import com.example.navigation.navigateSafe

@Composable
fun ArticlesComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<ArticlesViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickNewsItem = { viewModel.obtainEvent(ShowNewsEvent) },
        onClickPlayersItem = { viewModel.obtainEvent(ShowPlayersEvent) },
        onClickTestItem = {
            navController.navigateSafe(Screen.TestScreen.route)
        },
        onClickProfileItem = {
            viewModel.obtainEvent(ShowProfileEvent)
        }
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickNewsItem: () -> Unit,
    onClickPlayersItem: () -> Unit,
    onClickTestItem: () -> Unit,
    onClickProfileItem: () -> Unit,
) {
    state?.let { articlesState ->
        when (articlesState) {
            is InitArticles -> {
                InitArticlesUi(onClickNewsItem, onClickPlayersItem, onClickTestItem, onClickProfileItem)
            }
        }

    }
}

@Composable
private fun InitArticlesUi(
    onClickNewsItem: () -> Unit,
    onClickPlayersItem: () -> Unit,
    onClickTestItem: () -> Unit,
    onClickProfileItem: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FilledTonalButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = stringResource(id = com.example.common.R.string.article_show_news),
            onClick = onClickNewsItem,
            modifier = Modifier.fillMaxWidth()
        )

        FilledTonalButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = stringResource(id = com.example.common.R.string.article_show_players),
            onClick = onClickPlayersItem,
            modifier = Modifier.fillMaxWidth()
        )

        FilledTonalButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = stringResource(id = com.example.common.R.string.test_text_field),
            onClick = onClickTestItem,
            modifier = Modifier.fillMaxWidth()
        )

        FilledTonalButtonWithIcon(
            icon = ImageVector.vectorResource(id = com.example.common.R.drawable.ic_article),
            text = stringResource(id = com.example.common.R.string.show_profile),
            onClick = onClickProfileItem,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { articlesSideEffect ->
        when (articlesSideEffect) {
            is NewsEffect -> {
                navController.navigateSafe(Screen.NewsCategoryScreen.route)
            }
            is PlayersEffect -> {
                navController.navigateSafe(Screen.PlayersScreen.route)
            }
            is ProfileEffect -> {
                navController.navigateSafe(Screen.ProfileScreen.route)
            }
        }
    }
}