package com.example.featureEpisodes.crewEpisode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.SecondaryVariant
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.episodes.GuestCrewEpisodesModel
import com.example.domain.model.peoples.PeopleModel

@Composable
fun EpisodeCrewComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<EpisodeCrewViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(state)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?
) {
    state?.let { episodeState ->
        when (episodeState) {
            is EpisodeCrewSuccess -> {
                EpisodeCrewUi(episodeState.listCrew)
            }

            is EpisodeCrewLoading -> {
                DetailShimmerComponent()
            }

            is EpisodeCrewError -> {
                LoadError(episodeState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun EpisodeCrewUi(listCrew: List<GuestCrewEpisodesModel>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(listCrew) { _, item ->
            EpisodeCrewItem(item.peopleModel)
        }
    }
}

@Composable
private fun EpisodeCrewItem(peopleModel: PeopleModel) {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .shadow(8.dp, shape = RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {
        val (
            topImage, nameImage, nameText,
            countryText, countryValueText,
            genderText, genderValueText,
            birthdayText, birthdayValueText,
            bottomSpace
        ) = createRefs()

        AsyncImage(
            modifier = Modifier
                .constrainAs(topImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .height(400.dp),
            model = peopleModel.originalImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        AsyncImage(
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(nameImage) {
                    start.linkTo(parent.start)
                    top.linkTo(topImage.bottom)
                    end.linkTo(parent.end)
                }
                .size(100.dp)
                .clip(CircleShape),
            model = peopleModel.mediumImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Text(
            modifier = Modifier
                .constrainAs(nameText) {
                    start.linkTo(parent.start)
                    top.linkTo(nameImage.bottom)
                    end.linkTo(parent.end)
                }
                .wrapContentSize()
                .padding(top = 8.dp),
            text = peopleModel.name,
            style = MaterialTheme.typography.labelMedium,
            color = SecondaryVariant
        )

        Text(
            text = stringResource(id = R.string.country),
            modifier = Modifier
                .constrainAs(countryText) {
                    start.linkTo(parent.start)
                    top.linkTo(nameText.bottom)
                }
                .wrapContentSize()
                .padding(start = 16.dp, top = 36.dp),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = peopleModel.country,
            modifier = Modifier
                .constrainAs(countryValueText) {
                    start.linkTo(countryText.end)
                    bottom.linkTo(countryText.bottom)
                }
                .wrapContentSize()
                .padding(start = 4.dp).offset(y = 2.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(id = R.string.gender),
            modifier = Modifier
                .constrainAs(genderText) {
                    start.linkTo(parent.start)
                    top.linkTo(countryValueText.bottom)
                }
                .wrapContentSize()
                .padding(start = 16.dp, top = 16.dp),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = peopleModel.gender,
            modifier = Modifier
                .constrainAs(genderValueText) {
                    start.linkTo(genderText.end)
                    bottom.linkTo(genderText.bottom)
                }
                .wrapContentSize()
                .padding(start = 4.dp).offset(y = 2.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(id = R.string.birthday),
            modifier = Modifier
                .constrainAs(birthdayText) {
                    start.linkTo(parent.start)
                    top.linkTo(genderValueText.bottom)
                }
                .wrapContentSize()
                .padding(start = 16.dp, top = 16.dp),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = peopleModel.birthday,
            modifier = Modifier
                .constrainAs(birthdayValueText) {
                    start.linkTo(birthdayText.end)
                    bottom.linkTo(birthdayText.bottom)
                }
                .wrapContentSize()
                .padding(start = 4.dp).offset(y = 2.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier
            .constrainAs(bottomSpace) {
                start.linkTo(parent.start)
                top.linkTo(birthdayText.bottom)
            }
            .padding(top = 16.dp)
        )
    }
}