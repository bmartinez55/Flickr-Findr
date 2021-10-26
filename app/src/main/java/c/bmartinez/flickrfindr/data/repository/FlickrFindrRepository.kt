package c.bmartinez.flickrfindr.data.repository

import c.bmartinez.flickrfindr.data.dto.PhotosSearchResponse

interface FlickrFindrRepository {

    suspend fun getPhotos(
        searchTerm: String
    ): PhotosSearchResponse
}