package com.example.featureProfile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import com.example.common.BaseViewModel
import com.example.coreUi.Sample
import com.example.coreUi.components.BottomSheetUi
import com.example.domain.model.NewsModel
import com.example.domain.model.ProfileModel
import kotlinx.coroutines.launch

@Composable
fun ProfileComponent(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    //val state: ProfileViewState? by viewModel.state2.collectAsStateWithLifecycle()
    //https://medium.com/androiddevelopers/consuming-flows-safely-in-jetpack-compose-cde014d0d5a3
    val state: BaseViewModel.BaseViewState? by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect: BaseViewModel.BaseSideEffect? by viewModel.sideEffect.collectAsStateWithLifecycle(null)
//    sideEffect?.let {
//        when (sideEffect) {
//            is ProfileSideEffect.ShowToast -> {
//                Toast.makeText(LocalContext.current, "Exception: ", Toast.LENGTH_LONG).show()
//            }
//        }
 //   }
    ObserveState(navController, state)
}

@Composable
//private fun ObserveState(navController: NavController, viewState: ProfileViewState?) {
private fun ObserveState(navController: NavController, viewState: BaseViewModel.BaseViewState?) {
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