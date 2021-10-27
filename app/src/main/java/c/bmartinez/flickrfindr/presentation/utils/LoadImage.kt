package c.bmartinez.flickrfindr.presentation.utils

import android.annotation.SuppressLint
import android.content.ContentUris
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
import android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
import android.webkit.WebSettings
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadPicture(url: String?, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    val test: GlideUrl = GlideUrl(url, LazyHeaders.Builder()
        .addHeader("User-Agent", WebSettings.getDefaultUserAgent(LocalContext.current))
        .build()
    )

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object: CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(test)//Uri.parse(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .dontAnimate()
        .into(object: CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

        })
    return bitmapState
}