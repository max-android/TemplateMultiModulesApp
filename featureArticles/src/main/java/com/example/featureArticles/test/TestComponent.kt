package com.example.featureArticles.test

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.InputTransformation
import androidx.compose.foundation.text2.input.TextFieldBuffer
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.allCaps
import androidx.compose.foundation.text2.input.maxLengthInChars
import androidx.compose.foundation.text2.input.maxLengthInCodepoints
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.text2.input.then
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common.R
import com.example.coreUi.Typography
import com.example.featureArticles.ArticlesViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine
import kotlin.math.roundToInt

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TestComponent() {

    //val username = rememberSaveable { mutableStateOf("") }
    //val username = rememberTextFieldState()
    val viewModel = hiltViewModel<TestViewModel>()
    viewModel.validateUsername()
    var userNameHasError = mutableStateOf(false)

    val scrollState = rememberScrollState()
    val composableScope = rememberCoroutineScope()

    Column {
        Text(text = "пример 1", color = Color.Black)
        Spacer(modifier = Modifier.height(76.dp))
        BasicTextField2(
            state = viewModel.username,
            textStyle = Typography.titleMedium,
            modifier = Modifier
                .padding(36.dp)
                .border(4.dp, Color.Blue)
                .height(56.dp)
                .fillMaxWidth()
                .padding(8.dp),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(Color.Red),
            inputTransformation = DigitsOnlyTransformation,
            //inputTransformation = InputTransformation.maxLengthInChars(11),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            scrollState = scrollState,
        )
        Slider(
            value = scrollState.value.toFloat(),
            onValueChange = {
                composableScope.launch {
                    scrollState.scrollTo(it.roundToInt())
                }
            },
            valueRange = 0f..scrollState.maxValue.toFloat()
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
object DigitsOnlyTransformation : InputTransformation {
    override val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    override fun transformInput(
        originalValue: TextFieldCharSequence,
        valueWithChanges: TextFieldBuffer
    ) {
        if (!valueWithChanges.asCharSequence().isDigitsOnly()) {
            valueWithChanges.revertAllChanges()
        }
    }
}