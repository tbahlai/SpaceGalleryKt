package com.example.spacegallerykt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spacegallerykt.R
import com.example.spacegallerykt.data.Repository
import com.example.spacegallerykt.data.model.NasaApod
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.coroutines.Dispatchers
import java.security.Provider

class GalleryActivity : AppCompatActivity() {

    private lateinit var adapterGallery: GalleryAdapter
    private lateinit var viewModelGallery: GalleryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        viewModelGallery = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModelGallery.data.observe(this, Observer {data ->
            adapterGallery = GalleryAdapter(photos = data)
            recycler_view.layoutManager = GridLayoutManager(this@GalleryActivity, 2)
            recycler_view.adapter = adapterGallery
        })

    }
}
