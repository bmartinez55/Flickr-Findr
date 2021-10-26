package c.bmartinez.flickrfindr.di;

import androidx.annotation.NonNull;

import java.io.IOException;

import c.bmartinez.flickrfindr.utils.FlickrFindrConstants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyAuthInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder request = originalRequest
                .newBuilder()
                .header("api_key", FlickrFindrConstants.API_KEY);

        return chain.proceed(request.build());
    }
}
