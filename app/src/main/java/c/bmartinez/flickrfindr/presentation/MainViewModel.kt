package c.bmartinez.flickrfindr.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.flickrfindr.data.dto.PhotosSearchResponse
import c.bmartinez.flickrfindr.data.repository.FlickrFindrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    flickrFindrRepository: FlickrFindrRepository
): ViewModel(){

    private val _liveData: MutableLiveData<PhotosSearchResponse> = MutableLiveData()
    val state: MutableLiveData<PhotosSearchResponse> = _liveData

    
}