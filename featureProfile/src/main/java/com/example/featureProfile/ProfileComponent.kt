package com.example.featureProfile

import android.widget.Toast
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.domain.model.NewsModel
import com.example.domain.model.ProfileModel

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
                ProfileUi(viewState.list) {
                    navController.popBackStack()
                }
            }
            is ProfileViewState.ErrorProfileState -> {
                Text(
                    text = "HTTPException: "+viewState.code.toString().plus(viewState.message),
                    color = Color.Black
                )
                //Toast.makeText(LocalContext.current, "HTTPException: "+viewState.code.toString().plus(viewState.message), Toast.LENGTH_LONG).show()
            }
            is ProfileViewState.ExceptionProfileState -> {
                Text(
                    text = "Exception: "+viewState.throwable.message,
                    color = Color.Black
                )
              //  Toast.makeText(LocalContext.current, "Exception: "+viewState.throwable.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
private fun ProfileUi(profileModel: List<NewsModel>, onClickBack: () -> Unit) {
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
            text = profileModel.size.toString(),
            color = Color.Black
        )
    }
}