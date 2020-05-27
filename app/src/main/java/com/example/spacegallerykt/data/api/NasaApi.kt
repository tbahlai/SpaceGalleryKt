package com.example.spacegallerykt.data.api

import com.example.spacegallerykt.data.model.NasaApod
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("planetary/apod")
    suspend fun getApodCountPhotos(@Query("api_key") api_key: String,
                           @Query("count") count: Int,
                           @Query("hd") hd: Boolean): List<NasaApod>
}