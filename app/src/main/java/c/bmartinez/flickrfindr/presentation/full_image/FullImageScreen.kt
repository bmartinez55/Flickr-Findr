package c.bmartinez.flickrfindr.presentation.full_image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import c.bmartinez.flickrfindr.presentation.main_screen.MainViewModel
import c.bmartinez.flickrfindr.presentation.utils.loadPicture
import c.bmartinez.flickrfindr.utils.FlickrFindrConstants
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun FullImageScreen(
    navController: NavController,
    viewModel: FullImageViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        val image = loadPicture(state, FlickrFindrConstants.DEFAULT_IMAGE).value
        image?.let { img ->
            Image(
                bitmap = img.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }

//        GlideImage(
//            imageModel = state,
//            requestOptions = RequestOptions()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .disallowHardwareConfig()
//            ,
//            contentScale = ContentScale.Crop,
//            alignment = Alignment.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//        )

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            BackButton(
                onBackPress = {
                    navController.navigateUp()
                }
            )
        }
    }
}

@Composable
fun BackButton(onBackPress: () -> Unit){
    IconButton(onClick = onBackPress, modifier = Modifier.width(80.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = Color.Black,
                contentDescription = null
            )
            Text(
                text = "Back",
                modifier = Modifier
                    .padding(start = 5.dp, end = 0.dp, top = 0.dp, bottom = 0.dp),
                color = Color.Black
            )
        }
    }
}