package c.bmartinez.flickrfindr.data

import c.bmartinez.flickrfindr.data.dto.PhotosSearchResponse
import c.bmartinez.flickrfindr.utils.FlickrFindrConstants
import okhttp3.Response
import retrofit2.http.*

interface RetrofitApi {

    @Headers("Content-Type: application/json")
    @POST("?method=flickr.photos.search&api_key=${FlickrFindrConstants.API_KEY}&format=json&nojsoncallback=1")
    suspend fun getPhotos(
        @Query("text") searchTerm: String
    ): PhotosSearchResponse
}