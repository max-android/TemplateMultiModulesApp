package com.example.featureShows.crewShows

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.EmptyListUi
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.shows.CrewModel

@Composable
fun ShowsCrewComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<ShowsCrewViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(state)
}

@Composable
private fun ObserveState(state: BaseViewModel.BaseViewState?) {
    state?.let { crewState ->
        when (crewState) {
            is ShowsCrewSuccess -> {
                ShowsCrewUi(crewState.listCrew)
            }

            is ShowsCrewLoading -> {
                DetailShimmerComponent()
            }

            is ShowsCrewError -> {
                LoadError(crewState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun ShowsCrewUi(listCrew: List<CrewModel>) {
    if (listCrew.isEmpty()) {
        EmptyListUi()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(listCrew) { _, item ->
                ShowCrewItem(item)
            }
        }
    }
}

@Composable
private fun ShowCrewItem(crewModel: CrewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .background(color = colorResource(id = R.color.white))
            .border(2.dp, Color.Blue, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth(),
    ) {
        AsyncImage(
            model = crewModel.people.originalImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .fillMaxWidth()
                .height(600.dp),
        )
        Text(
            text = crewModel.typeCrew,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.displayLarge
        )
        CrewItem(crewModel)
    }
}

@Composable
private fun CrewItem(crewModel: CrewModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = crewModel.people.mediumImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(bottomStart = 16.dp))
                .fillMaxWidth()
                .height(300.dp)
                .weight(1f),
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(color = colorResource(id = R.color.white))
                .fillMaxWidth()
                .weight(1f),
        ) {
            Text(
                text = crewModel.people.name,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = crewModel.people.gender,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp, top = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = crewModel.people.birthday,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp, top = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.country),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp, top = 8.dp),
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = crewModel.people.country,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 2.dp, top = 8.dp),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

