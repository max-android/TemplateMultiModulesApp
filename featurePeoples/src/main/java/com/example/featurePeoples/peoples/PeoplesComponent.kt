package com.example.featurePeoples.peoples

import androidx.compose.foundation.clickable
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
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.coreUi.workComponents.ListShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.coreUi.workComponents.EmptyListUi
import com.example.domain.model.peoples.PeopleModel
import com.example.navigation.KEY_PEOPLE_ID
import com.example.navigation.Screen
import com.example.navigation.navigateWithBundleSafe

@Composable
fun PeoplesComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<PeoplesViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    val context = LocalContext.current
    ObserveState(
        state,
        onClickItem = { peopleId -> viewModel.obtainEvent(ShowPeopleDetailEvent(peopleId)) }
    )
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?,
    onClickItem: (String) -> Unit,
) {
    state?.let { peoplesState ->
        when (peoplesState) {
            is PeoplesListSuccess -> {
                PeoplesListUi(
                    peoplesState.peoples,
                    onClickItem,
                )
            }

            is PeoplesListEmpty -> {
                EmptyListUi()
            }

            is PeoplesListLoading -> {
                ListShimmerComponent()
            }

            is PeoplesListError -> {
                LoadError(peoplesState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun PeoplesListUi(
    peoples: List<PeopleModel>,
    onClickItem: (String) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(peoples) { _, item ->
            PeopleItem(
                item,
                onClickItem,
            )
        }
    }
}

@Composable
private fun PeopleItem(
    item: PeopleModel,
    onClickItem: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClickItem.invoke(item.id) }
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        AsyncImage(
            model = item.mediumImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(250.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(item.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                item.country, style = MaterialTheme.typography.labelLarge,
                color = colorResource(
                    id = com.example.common.R.color.red
                )
            )
        }
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { peopleSideEffect ->
        when (peopleSideEffect) {
            is PeopleDetailEffect -> {
                navController.navigateWithBundleSafe(
                    Screen.PeopleDetailScreen.route,
                    bundleOf(KEY_PEOPLE_ID to peopleSideEffect.peopleId)
                )
            }
        }
    }
}