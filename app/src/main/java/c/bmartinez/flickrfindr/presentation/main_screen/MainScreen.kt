package c.bmartinez.flickrfindr.presentation.main_screen

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import c.bmartinez.flickrfindr.presentation.main_screen.components.PhotosLazyColumn
import c.bmartinez.flickrfindr.presentation.utils.ToolBar

@Composable
fun MainScreen(
    navController: NavController,
    focusManager: FocusManager,
    viewModel: MainViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopStart)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        viewModel.onQueryTermClear()
                        focusManager.clearFocus(true)
                    })
                }
        ) {
            ToolBar(focusManager)
            PhotosLazyColumn(navController)
        }
    }
}