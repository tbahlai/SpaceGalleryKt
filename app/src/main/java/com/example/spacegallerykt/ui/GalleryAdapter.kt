package com.example.spacegallerykt.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacegallerykt.R
import com.example.spacegallerykt.data.model.NasaApod

class GalleryAdapter(private val photos: List<NasaApod>): RecyclerView.Adapter<GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_image, parent, false)
        return GalleryViewHolder(view)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        when (holder) {
            is GalleryViewHolder -> {holder.bind(photos[position])}
        }
    }
}