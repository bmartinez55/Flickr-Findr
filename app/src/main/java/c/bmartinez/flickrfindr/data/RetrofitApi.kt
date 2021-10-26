package c.bmartinez.flickrfindr.data

import c.bmartinez.flickrfindr.data.dto.PhotosSearchResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("?method=flickr.photos.search")
    suspend fun getPhotos(
        @Query("term") searchTerm: String
    ): PhotosSearchResponse
}