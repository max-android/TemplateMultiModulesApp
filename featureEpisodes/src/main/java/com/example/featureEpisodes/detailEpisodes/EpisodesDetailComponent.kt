package com.example.featureEpisodes.detailEpisodes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.Purple700
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.episodes.EpisodesModel

@Composable
fun EpisodeDetailComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<EpisodeDetailViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(state)
}

@Composable
private fun ObserveState(
    state: BaseViewModel.BaseViewState?
) {
    state?.let { episodeState ->
        when (episodeState) {
            is EpisodeDetailSuccess -> {
                EpisodesDetailUi(episodeState.episodesModel)
            }

            is EpisodeDetailLoading -> {
                DetailShimmerComponent()
            }

            is EpisodeDetailError -> {
                LoadError(episodeState.exception)
            }

            else -> {
            }
        }
    }
}


@Composable
fun EpisodesDetailUi(item: EpisodesModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
               // onClickItem.invoke(item.id)
            }
    ) {
        AsyncImage(
            model = item.mediumImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = item.name,
            style = MaterialTheme.typography.headlineMedium,
            color = Purple700
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.summary,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.purple_700)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.date),
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(id = R.color.purple_700)
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Bottom)
                    .padding(start = 16.dp, bottom = 4.dp),
                text = item.airdate,
                style = MaterialTheme.typography.labelLarge,
                color = colorResource(id = R.color.black)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.shows_rating),
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(id = R.color.purple_700)
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Bottom)
                    .padding(start = 16.dp, bottom = 4.dp),
                text = item.rating,
                style = MaterialTheme.typography.labelLarge,
                color = colorResource(id = R.color.black)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.duration),
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(id = R.color.purple_700)
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Bottom)
                    .padding(start = 16.dp, bottom = 4.dp),
                text = item.duration,
                style = MaterialTheme.typography.labelLarge,
                color = colorResource(id = R.color.black)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .clickable {
                   // onClickGuestCast.invoke(item.id)
                }
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
            text = stringResource(id = R.string.guest_cast),
            style = MaterialTheme.typography.labelMedium,
            color = colorResource(id = R.color.red)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .clickable {
                 //   onClickGuestCrew.invoke(item.id)
                }
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
            text = stringResource(id = R.string.guest_crew),
            style = MaterialTheme.typography.labelMedium,
            color = colorResource(id = R.color.red)
        )
        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Preview
@Composable
fun EpisodesDetailPreview() {

}