package c.bmartinez.flickrfindr.data.repository

import c.bmartinez.flickrfindr.data.RetrofitApi
import javax.inject.Inject

class FlickrFindrRepositoryImpl @Inject constructor(
    private val retrofitApi: RetrofitApi
): FlickrFindrRepository {
    override suspend fun getPhotos(
        searchTerm: String
    ) = retrofitApi.getPhotos(searchTerm)
}