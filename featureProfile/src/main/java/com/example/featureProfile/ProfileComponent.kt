package com.example.featureProfile

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavBackStackEntry
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.Black
import com.example.coreUi.components.Person
import com.example.coreUi.components.readyUi.TextButtonWithIcon
import com.example.coreUi.workComponents.Line
import com.example.coreUi.workComponents.LoadError
import com.example.domain.model.players.PlayerModel
import com.example.featureProfile.uiComponents.EditProfileItem
import com.example.featureProfile.uiComponents.HeaderItem
import com.example.featureProfile.uiComponents.HistoryList
import com.example.featureProfile.uiComponents.ProfileHeader
import com.example.featureProfile.uiComponents.Setting3Item
import com.example.featureProfile.uiComponents.Settings1Item
import com.example.featureProfile.uiComponents.Settings2Item
import com.example.navigation.parcelableData

@Composable
fun ProfileComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {

    //TODO пример с передачей объектов по компонентам
    Log.i("--DATA", "-------------- " + navBackStackEntry.parcelableData<Person>("myKey"))

    val viewModel = hiltViewModel<ProfileViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val sideEffect by viewModel.sideEffect.collectAsStateWithLifecycle(null)
    ObserveState(state)
    ObserveSideEffect(sideEffect, navController)
}

@Composable
private fun ObserveState(state: BaseViewModel.BaseViewState?) {
    state?.let { profileState ->
        when (profileState) {
            is SuccessProfileState -> {
                ConfigureProfileUi()
            }

            is ErrorProfileState -> {
                LoadError(profileState.exception)
            }
        }
    }
}

@Composable
private fun ConfigureProfileUi() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = colorResource(id = com.example.common.R.color.gray))
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ProfileHeader()
        Spacer(modifier = Modifier.height(36.dp))
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
                .background(
                    color = colorResource(id = com.example.common.R.color.paleSky)
                )
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            EditProfileItem()
            Spacer(modifier = Modifier.height(24.dp))
            HeaderItem(R.string.title_profile_setting_1)
            Settings1Item()
            Spacer(modifier = Modifier.height(24.dp))
            HeaderItem(R.string.title_profile_setting_2)
            Settings2Item()
            Spacer(modifier = Modifier.height(24.dp))
            HeaderItem(R.string.title_profile_setting_3)
            Setting3Item()
            Spacer(modifier = Modifier.height(16.dp))
            Line()
            Spacer(modifier = Modifier.height(16.dp))
            HeaderItem(R.string.title_history)
            HistoryList()
            Spacer(modifier = Modifier.height(8.dp))
            TextButtonWithIcon(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                icon = ImageVector.vectorResource(id = R.drawable.ic_article),
                text = stringResource(id = R.string.title_history),
                onClick = {}
            )
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}

@Composable
private fun ObserveSideEffect(
    sideEffect: BaseViewModel.BaseSideEffect?,
    navController: NavController
) {
    sideEffect?.let { profileSideEffect ->
        when (profileSideEffect) {
            is UpdateProfileEffect -> {

            }
        }
    }
}

@Preview
@Composable
fun SamplesProfilePreview() {
    ConfigureProfileUi()
}