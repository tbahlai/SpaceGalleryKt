package com.example.spacegallerykt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spacegallerykt.data.Repository
import kotlinx.coroutines.Dispatchers

class GalleryViewModel: ViewModel() {

    private val retrofitRep: Repository = Repository()

    val data = liveData(Dispatchers.IO) {
        val ph = retrofitRep.getPhotos()
        emit(ph)
    }
}