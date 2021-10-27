package c.bmartinez.flickrfindr.presentation.full_image

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import c.bmartinez.flickrfindr.utils.constructImageUrlInSections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FullImageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val state: MutableState<String> = mutableStateOf("")

    init {
        var server = ""
        var id = ""
        var secret = ""
        savedStateHandle.get<String>("server")?.let {
            server = it
        }
        savedStateHandle.get<String>("id")?.let {
            id = it
        }
        savedStateHandle.get<String>("secret")?.let {
            secret = it
        }
        val imageUrl = constructImageUrlInSections(server, id, secret)
        state.value = imageUrl.trim()
    }
}