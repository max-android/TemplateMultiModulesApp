package com.example.featurePlayer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

@Composable
fun getTabs(): List<TabItem> {
    return listOf<TabItem>(
        TabItem(
            stringResource(id = com.example.common.R.string.players_tab_players),
            ImageVector.vectorResource(id = com.example.common.R.drawable.ic_player),
            ImageVector.vectorResource(id = com.example.common.R.drawable.ic_player)
        ),
        TabItem(
            stringResource(id = com.example.common.R.string.players_tab_teams),
            ImageVector.vectorResource(id = com.example.common.R.drawable.ic_team),
            ImageVector.vectorResource(id = com.example.common.R.drawable.ic_team)
        ),
        TabItem(
            stringResource(id = com.example.common.R.string.players_tab_games),
            ImageVector.vectorResource(id = com.example.common.R.drawable.ic_game),
            ImageVector.vectorResource(id = com.example.common.R.drawable.ic_game)
        )
    )
}

