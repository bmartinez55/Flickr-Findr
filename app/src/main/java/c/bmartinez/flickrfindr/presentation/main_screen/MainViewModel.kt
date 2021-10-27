package c.bmartinez.flickrfindr.presentation.main_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.bmartinez.flickrfindr.data.dto.Photo
import c.bmartinez.flickrfindr.data.repository.FlickrFindrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val flickrFindrRepository: FlickrFindrRepository
): ViewModel(){

    val state: MutableState<List<Photo>> = mutableStateOf(emptyList())

    //Initializing the queryTerm variable to Manhwa first.
    val queryTerm = mutableStateOf("")

    val fullSizeImageUrl = mutableStateOf("")

    init {
        getPhotos("jdm")
    }

    fun getPhotos(searchTerm: String) {
        viewModelScope.launch {
            try{
                val response = flickrFindrRepository.getPhotos(searchTerm)
                state.value = response.photosMetaData.photo
            } catch (e: Exception) {
                Log.d("MainViewModel", e.stackTraceToString())
            }
        }
    }

    fun onFullSizeImageUrlChange(imageUrl: String) {
        this.fullSizeImageUrl.value = imageUrl
    }

    fun onQueryTermChange(query: String) {
        this.queryTerm.value = query
    }

    fun onQueryTermClear() {
        this.queryTerm.value = ""
    }
}