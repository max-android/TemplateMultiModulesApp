package com.example.featurePlayer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.components.TestTextComponent
import com.example.coreUi.workComponents.ListShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.peoples.PeopleModel
import com.example.domain.model.players.GameModel
import com.example.domain.model.players.PlayerModel
import com.example.domain.model.players.TeamModel
import com.example.navigation.KEY_PEOPLE_ID
import com.example.navigation.Screen
import com.example.navigation.navigateWithBundleSafe

@Composable
fun PlayersComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<PlayersViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickPlayerItem = {
            //peopleId -> viewModel.obtainEvent()
        },
        onClickTeamItem = {

        },
        onClickGameItem = {

        },
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickPlayerItem: (String) -> Unit,
    onClickTeamItem: (String) -> Unit,
    onClickGameItem: (String) -> Unit,
) {
    state?.let { playersState ->
        when (playersState) {
            is PlayersListLoading -> {
                ListShimmerComponent()
            }

            is PlayersListSuccess -> {
                ConfigureUi(playersState, onClickPlayerItem, onClickTeamItem, onClickGameItem)
            }

            is PlayersListError -> {
                LoadError(playersState.exception)
            }

            else -> {
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun ConfigureUi(
    playersSuccess: PlayersListSuccess,
    onClickPlayerItem: (String) -> Unit,
    onClickTeamItem: (String) -> Unit,
    onClickGameItem: (String) -> Unit,
) {
    val selectedTabIndex = remember {
        mutableIntStateOf(0)
    }
    val pagerSize = getTabs().size
    val pagerState = rememberPagerState {
        pagerSize
    }
    LaunchedEffect(key1 = selectedTabIndex.intValue, block = {
        pagerState.animateScrollToPage(selectedTabIndex.intValue)
    })
    LaunchedEffect(key1 = pagerState.currentPage, key2 = pagerState.isScrollInProgress, block = {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex.intValue = pagerState.currentPage
        }
    })
    Column(modifier = Modifier.fillMaxSize()) {
        PrimaryTabRow(selectedTabIndex = selectedTabIndex.intValue) {
            getTabs().forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex.intValue,
                    onClick = { selectedTabIndex.intValue = index },
                    text = { Text(text = tabItem.title) },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex.intValue) {
                                tabItem.selectedIcon
                            } else {
                                tabItem.unselectedIcon
                            },
                            contentDescription = tabItem.title,
                            tint = Color.Blue
                        )
                    },
                    selectedContentColor = colorResource(id = com.example.common.R.color.red),
                    unselectedContentColor = colorResource(id = com.example.common.R.color.black)
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                //.fillMaxSize()
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            when (index) {
                0 -> {
                    PlayersListUi(playersSuccess.players, onClickPlayerItem)
                }

                1 -> {
                    TeamListUi(playersSuccess.teams, onClickTeamItem)
                }

                2 -> {
                    GameListUi(playersSuccess.games, onClickGameItem)
                }

                else -> {

                }
            }
        }
    }
}

@Composable
private fun PlayersListUi(
    players: List<PlayerModel>,
    onClickPlayerItem: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
    ) {
        itemsIndexed(players) { _, item ->
            PlayerItem(
                item,
                onClickPlayerItem,
            )
        }
    }
}

@Composable
private fun PlayerItem(item: PlayerModel, onClickPlayerItem: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .clickable { onClickPlayerItem.invoke(item.id.toString()) }
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = item.firstName.plus(" ").plus(item.lastName),
            style = MaterialTheme.typography.labelLarge,
            color = colorResource(id = R.color.black)
        )
    }
}

@Composable
private fun TeamListUi(
    teams: List<TeamModel>,
    onClickTeamItem: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState
        // modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(teams) { _, item ->
            TeamItem(
                item,
                onClickTeamItem,
            )
        }
    }
}

@Composable
private fun TeamItem(item: TeamModel, onClickTeamItem: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .clickable { onClickTeamItem.invoke(item.id.toString()) }
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = item.fullName,
            style = MaterialTheme.typography.labelLarge,
            color = colorResource(id = R.color.black)
        )
    }
}

@Composable
private fun GameListUi(
    teams: List<GameModel>,
    onClickGameItem: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState
        // modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(teams) { _, item ->
            GameItem(
                item,
                onClickGameItem,
            )
        }
    }
}

@Composable
private fun GameItem(item: GameModel, onClickGameItem: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .clickable { onClickGameItem.invoke(item.id.toString()) }
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = item.status,
            style = MaterialTheme.typography.labelLarge,
            color = colorResource(id = R.color.black)
        )
    }
}


@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { playersSideEffect ->
        when (playersSideEffect) {
//            is PeopleDetailEffect -> {
//                navController.navigateWithBundleSafe(
//                    Screen.PeopleDetailScreen.route,
//                    bundleOf(KEY_PEOPLE_ID to peopleSideEffect.peopleId)
//                )
//            }
        }
    }
}


@Preview
@Composable
fun SamplesPlayersPreview() {
    val model = PlayerModel(0, "Имя", "Фамилия", "", 0, 0, 0)
    PlayersListUi(listOf(model, model), {})
}