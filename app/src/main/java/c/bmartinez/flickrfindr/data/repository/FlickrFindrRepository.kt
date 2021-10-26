package c.bmartinez.flickrfindr.data.repository

import c.bmartinez.flickrfindr.data.dto.PhotosSearchResponse
import okhttp3.Response

interface FlickrFindrRepository {

    suspend fun getPhotos(
        searchTerm: String
    ): PhotosSearchResponse
}