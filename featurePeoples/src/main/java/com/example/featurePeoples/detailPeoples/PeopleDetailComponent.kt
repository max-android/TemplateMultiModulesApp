package com.example.featurePeoples.detailPeoples

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.Purple700
import com.example.coreUi.components.OpenWeb
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.peoples.PeopleModel
import com.example.navigation.KEY_PEOPLE_ID
import com.example.navigation.Screen
import com.example.navigation.navigateWithBundleSafe

@Composable
fun PeopleDetailComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<PeopleDetailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(
        state,
        onClickSiteItem = { urlSite -> viewModel.obtainEvent(ShowSitePeoplesEvent(urlSite)) },
        onClickCharactersItem = { viewModel.obtainEvent(ShowPeopleCharactersEvent) }
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickSiteItem: (String) -> Unit,
    onClickCharactersItem: () -> Unit
) {
    state?.let { showsState ->
        when (showsState) {
            is PeopleDetailSuccess -> {
                PeopleUi(showsState.people, onClickSiteItem, onClickCharactersItem)
            }

            is PeopleDetailLoading -> {
                DetailShimmerComponent()
            }

            is PeopleDetailError -> {
                LoadError(showsState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun PeopleUi(
    item: PeopleModel,
    onClickSiteItem: (String) -> Unit,
    onClickCharactersItem: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxWidth()
            .verticalScroll(scrollState),
    ) {
        AsyncImage(
            model = item.originalImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = item.name,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.gender),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.gender,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 4.dp)
                    .align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.birthday),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.birthday,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 4.dp)
                    .align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.shows_site),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.url,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 4.dp, end = 16.dp)
                    .align(Alignment.Bottom)
                    .clickable { onClickSiteItem.invoke(item.url) },
                style = MaterialTheme.typography.labelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.country),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = item.country,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 4.dp)
                    .align(Alignment.Bottom),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .clickable { onClickCharactersItem.invoke() }
                .padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
            text = stringResource(id = R.string.characters),
            style = MaterialTheme.typography.labelMedium,
            color = Purple700
        )
        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { showsSideEffect ->
        when (showsSideEffect) {
            is ShowSitePeoplesEffect -> {
                OpenWeb(showsSideEffect.url)
            }

            is PeopleCharactersEffect -> {
                navController.navigateWithBundleSafe(
                    Screen.PeopleCharactersScreen.route,
                    bundleOf(KEY_PEOPLE_ID to showsSideEffect.peopleId)
                )
            }
        }
    }
}