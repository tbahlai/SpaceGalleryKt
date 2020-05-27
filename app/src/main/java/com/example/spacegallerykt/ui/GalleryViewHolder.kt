package com.example.spacegallerykt.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.spacegallerykt.data.model.NasaApod
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_image.view.*

class GalleryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(photos: NasaApod) {
        Picasso.get().load(photos.url).into(itemView.image_planet)
        itemView.title_photo.text = photos.title
    }
}