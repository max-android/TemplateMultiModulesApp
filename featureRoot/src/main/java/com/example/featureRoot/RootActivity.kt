package com.example.featureRoot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.coreUi.BaseTheme
import com.example.coreUi.TemplateMultiModulesAppTheme
import com.example.navigation.Screen
import com.example.navigation.ScreenStarter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    @Inject
    lateinit var screenStarter: ScreenStarter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController, startDestination = Screen.RootScreen.route
                    ) {
                        screenStarter.startRoot().create(this, navController)
                        screenStarter.startProfile().create(this, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) = Text(text = "Hello $name!")

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemplateMultiModulesAppTheme {
        Greeting("Android")
    }
}