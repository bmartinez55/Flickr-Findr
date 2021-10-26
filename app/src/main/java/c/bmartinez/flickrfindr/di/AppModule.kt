package c.bmartinez.flickrfindr.di

import android.content.Context
import c.bmartinez.flickrfindr.MyApplication
import c.bmartinez.flickrfindr.data.RetrofitApi
import c.bmartinez.flickrfindr.data.repository.FlickrFindrRepository
import c.bmartinez.flickrfindr.data.repository.FlickrFindrRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MyApplication {
        return app as MyApplication
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitApi = retrofit.create(RetrofitApi::class.java)

    @Singleton
    @Provides
    fun provideFlickrFindrRepository(retrofitApi: RetrofitApi): FlickrFindrRepository {
        return FlickrFindrRepositoryImpl(retrofitApi)
    }
}