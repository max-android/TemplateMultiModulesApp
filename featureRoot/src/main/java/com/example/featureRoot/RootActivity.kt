package com.example.featureRoot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coreUi.TemplateMultiModulesAppTheme
import com.example.navigation.ScreenStarter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.BaseViewModel

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    @Inject
    lateinit var screenStarter: ScreenStarter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfigureRoot()
        }
    }

    @Composable
    private fun ConfigureRoot() {
        val viewModel = hiltViewModel<RootViewModel>()
        val state: BaseViewModel.BaseViewState? by viewModel.state.collectAsStateWithLifecycle()
        ObserveState(state)
    }

    @Composable
    private fun ObserveState(viewState: BaseViewModel.BaseViewState?) {
        viewState?.let {
            when (viewState) {
                is RootViewState.SuccessRoot -> {
                    val isDarkMode = remember { mutableStateOf(viewState.isDarkTheme) }
                    TemplateMultiModulesAppTheme(isDarkMode.value) {
                        //val systemUiController = rememberSystemUiController()
                        // Set status bar color
//                        SideEffect {
//                            systemUiController.setSystemBarsColor(
//                                color = if (isDarkMode.value) darkThemeColors.primary
//                                else lightThemeColors.primary,
//                                darkIcons = !isDarkMode.value
//                            )
//                        }
                        BaseRootComponent(screenStarter) {

                        }
                    }
                }
                else -> {}
            }
        }
    }

}