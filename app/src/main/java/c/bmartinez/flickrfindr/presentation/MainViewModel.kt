package c.bmartinez.flickrfindr.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.bmartinez.flickrfindr.data.dto.PhotosSearchResponse
import c.bmartinez.flickrfindr.data.repository.FlickrFindrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val flickrFindrRepository: FlickrFindrRepository
): ViewModel(){

    private val _liveData: MutableLiveData<PhotosSearchResponse> = MutableLiveData()
    val state: MutableLiveData<PhotosSearchResponse> = _liveData

    val queryTerm: MutableLiveData<String> = MutableLiveData("")

    suspend fun getPhotos(searchTerm: String) {
        viewModelScope.launch {
            try{
                val response = flickrFindrRepository.getPhotos(searchTerm)
                if(response != null){
                    _liveData.value = response
                }
            } catch (e: Exception) {
                Log.d("MainViewModel", e.stackTraceToString())
            }
        }
    }

    fun onSearchTermClear() {
        this.queryTerm.value = ""
    }

    fun onQueryTermChange(query: String) {
        this.queryTerm.value = query
    }
}