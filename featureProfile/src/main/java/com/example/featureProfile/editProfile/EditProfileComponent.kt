package com.example.featureProfile.editProfile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.common.BaseViewModel
import com.example.common.R
import com.example.coreUi.Black
import com.example.coreUi.Typography
import com.example.coreUi.workComponents.LoadError
import com.example.featureProfile.profile.ErrorProfileState

@Composable
fun EditProfileComponent(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val viewModel: EditProfileViewModel = hiltViewModel<EditProfileViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ObserveState(
        viewModel,
        state,
        onClickEditProfileItem = {
            viewModel.obtainEvent(UpdateProfileEvent)
        }
    )
}

@Composable
private fun ObserveState(
    viewModel: EditProfileViewModel,
    state: BaseViewModel.BaseViewState?,
    onClickEditProfileItem: () -> Unit
) {
    state?.let { profileState ->
        when (profileState) {
            is SuccessInitProfileState -> {
                ConfigureEditProfileUi(viewModel, onClickEditProfileItem)
            }

            is ErrorProfileState -> {
                LoadError(profileState.exception)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ConfigureEditProfileUi(
    viewModel: EditProfileViewModel,
    onConfirmClick: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.validateProfile()
    }
    val scrollState = rememberScrollState()
    val confirmEnabled by viewModel.stateProfileConfirm.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.gray))
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.title_profile_update),
            style = MaterialTheme.typography.headlineMedium,
            color = Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField2(
            state = viewModel.profileName,
            textStyle = Typography.labelLarge,
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Blue, shape = RoundedCornerShape(16.dp))
                .height(56.dp)
                .fillMaxWidth()
                .padding(16.dp),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(Color.Red),
            //inputTransformation = InputTransformation.maxLengthInChars(11),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            scrollState = scrollState,
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField2(
            state = viewModel.profilePhone,
            textStyle = Typography.labelLarge,
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Blue, shape = RoundedCornerShape(16.dp))
                .height(56.dp)
                .fillMaxWidth()
                .padding(16.dp),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(Color.Red),
            //inputTransformation = InputTransformation.maxLengthInChars(11),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            scrollState = scrollState,
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            modifier = Modifier.then(
                if (confirmEnabled) Modifier else Modifier.alpha(0.5F)
            ),
            onClick = onConfirmClick,
            enabled = confirmEnabled,
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = if (confirmEnabled) stringResource(id = R.string.confirm)
                else stringResource(id = R.string.confirm_disabled),
                modifier = Modifier
                    .padding(start = 36.dp, end = 36.dp, top = 8.dp, bottom = 8.dp)
            )
        }

    }
}

@Preview
@Composable
fun SamplesProfilePreview() {
    //ConfigureEditProfileUi()
}