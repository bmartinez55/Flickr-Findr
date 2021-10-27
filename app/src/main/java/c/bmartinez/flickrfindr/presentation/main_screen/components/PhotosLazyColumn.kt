package c.bmartinez.flickrfindr.presentation.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import c.bmartinez.flickrfindr.presentation.main_screen.MainViewModel
import c.bmartinez.flickrfindr.presentation.Screen
import c.bmartinez.flickrfindr.utils.constructImageUrl

@Composable
fun PhotosLazyColumn(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column {
        LazyColumn {
            itemsIndexed(state) { index, photo ->
                PhotoItem(
                    photo,
                    onClick = {
                        val url = constructImageUrl(photo)
                        url.let { imageUrl ->
                            navController.navigate(
                                route = Screen.FullImageScreen.route + "/${photo.secret}" + "/${photo.id}" + "/${photo.secret}"
                            )
                        }
                    }
                )
            }
        }
    }
}