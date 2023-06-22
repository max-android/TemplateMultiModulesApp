package com.example.featurePeoples.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.workComponents.DetailShimmerComponent
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.peoples.CharacterModel
import com.example.domain.model.peoples.PeopleModel
import com.example.featurePeoples.detailPeoples.PeopleDetailError
import com.example.featurePeoples.detailPeoples.PeopleDetailLoading
import com.example.featurePeoples.detailPeoples.PeopleDetailSuccess

@Composable
fun PeopleCharactersComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel = hiltViewModel<PeopleCharactersViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(state)
}

@Composable
private fun ObserveState(state: BaseViewModel.BaseViewState?) {
    state?.let { showsState ->
        when (showsState) {
            is PeopleCharactersSuccess -> {
                CharacterUi(showsState.character)
            }

            is PeopleCharactersLoading -> {
                DetailShimmerComponent()
            }

            is PeopleCharactersError -> {
                LoadError(showsState.exception)
            }

            else -> {
            }
        }
    }
}

@Composable
private fun CharacterUi(item: CharacterModel) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxWidth(),
    ) {
        AsyncImage(
            model = item.originalImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = item.name,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}