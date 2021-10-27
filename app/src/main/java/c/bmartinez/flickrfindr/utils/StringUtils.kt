package c.bmartinez.flickrfindr.utils

import c.bmartinez.flickrfindr.data.dto.Photo

fun constructImageUrl(photo: Photo): String{
    return "https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
}

fun constructImageUrlInSections(
    server: String,
    id: String,
    secret: String
): String {
    return "https://live.staticflickr.com/${server.trim()}/${id.trim()}_${secret.trim()}.jpg"
}