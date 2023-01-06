package com.example.featureProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.*
import com.example.domain.ProfileModel

@Composable
fun ProfileComponent(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val state: ProfileViewState? by viewModel.state.collectAsState()
    ObserveState(navController, state)
}

@Composable
private fun ObserveState(navController: NavController, viewState: ProfileViewState?) {
    viewState?.let {
        when (viewState) {
            is ProfileViewState.SuccessProfileState -> {
                ProfileUi(viewState.profileModel) {
                    navController.popBackStack()
                }
            }
            is ProfileViewState.ErrorProfileState -> {

            }
        }
    }
}

@Composable
private fun ProfileUi(profileModel: ProfileModel, onClickBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = com.example.coreUi.R.drawable.ic_backspace),
            modifier = Modifier.clickable {
                onClickBack.invoke()
            },
            contentDescription = null
        )
        Text(
            //text = stringResource(id = com.example.coreUi.R.string.title_profile),
            text = profileModel.name,
            color = Color.Black
        )
    }
}