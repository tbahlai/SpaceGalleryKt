package com.example.spacegallerykt.data

import com.example.spacegallerykt.BuildConfig
import com.example.spacegallerykt.data.api.NasaApi

class Repository {
    val retrofitClient: NasaApi = RetrofitService().retrofitService
    suspend fun getPhotos() = retrofitClient.getApodCountPhotos(BuildConfig.API_KEY, 30, true)
}