package c.bmartinez.flickrfindr.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import c.bmartinez.flickrfindr.presentation.full_image.FullImageScreen
import c.bmartinez.flickrfindr.presentation.main_screen.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(color = MaterialTheme.colors.background) {
                val navController = rememberNavController()
                val focusManager = LocalFocusManager.current

                NavHost(
                    navController = navController,
                    startDestination = Screen.MainScreen.route
                ) {
                    composable(
                        route = Screen.MainScreen.route
                    ) {
                        MainScreen(navController, focusManager)
                    }
                    composable(
                        route = Screen.FullImageScreen.route + "/{server}" +"/{id}" + "/{secret}"
                    ) {
                        FullImageScreen(navController)
                    }
                }
            }
        }
    }
}