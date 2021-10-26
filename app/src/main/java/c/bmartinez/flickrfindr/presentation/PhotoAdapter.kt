package c.bmartinez.flickrfindr.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.flickrfindr.R
import c.bmartinez.flickrfindr.data.dto.Photo
import com.bumptech.glide.Glide
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PhotoAdapter @Inject constructor(
    private val photoList: List<Photo>,
    private val context: Context
): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.photo_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = photoList[position]

        val serverId = item.server
        val photoId = item.id
        val secret = item.secret
        val imageUrl = "https://live.staticflickr.com/${serverId}/${photoId}_${secret}_q.jpg"

        Glide.with(context)
            .load(imageUrl)
            .into(holder.imageView)

        holder.textView.text = item.title.toString()
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class ViewHolder(private val v: View): RecyclerView.ViewHolder(v) {
        val imageView: AppCompatImageView = v.findViewById(R.id.image_view_item)
        val textView: TextView = v.findViewById(R.id.text_view_item)
    }
}