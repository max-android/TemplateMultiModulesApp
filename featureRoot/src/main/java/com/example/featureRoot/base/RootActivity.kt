package com.example.featureRoot.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coreUi.TemplateMultiModulesAppTheme
import com.example.navigation.ScreenStarter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.BaseViewModel
import com.example.featureRoot.root.SuccessRoot

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    @Inject
    lateinit var screenStarter: ScreenStarter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Window Inset
        //https://habr.com/ru/companies/kts/articles/687310/
        setContent {
            ConfigureRoot()
        }
    }

    @Composable
    private fun ConfigureRoot() {
        val viewModel = hiltViewModel<BaseRootViewModel>()
        val state: BaseViewModel.BaseViewState? by viewModel.state.collectAsStateWithLifecycle()
        ObserveState(state)
    }

    @Composable
    private fun ObserveState(viewState: BaseViewModel.BaseViewState?) {
        viewState?.let {
            when (viewState) {
                is SuccessRoot -> {
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