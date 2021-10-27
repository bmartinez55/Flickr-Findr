package c.bmartinez.flickrfindr.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import c.bmartinez.flickrfindr.R
import c.bmartinez.flickrfindr.data.dto.Photo
import c.bmartinez.flickrfindr.presentation.utils.loadPicture
import c.bmartinez.flickrfindr.utils.FlickrFindrConstants
import c.bmartinez.flickrfindr.utils.constructImageUrl

@Composable
fun PhotoItem(
    photo: Photo,
    onClick : () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(width = 0.dp, color = Color.Transparent, shape = RectangleShape)
            .clickable(onClick = onClick)
        ,
        elevation = 10.dp
    ) {
        Column {
            val imageUrl = constructImageUrl(photo)
            val image = loadPicture(imageUrl, FlickrFindrConstants.DEFAULT_IMAGE).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 0.dp, top = 5.dp, bottom = 5.dp)
                    .wrapContentWidth(Alignment.Start)
                ,
                text = photo.title.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

