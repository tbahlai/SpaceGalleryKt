package com.example.spacegallerykt.data.model

//data class NasaApod(
//    val photosApods: List<DataApod>
//)

data class NasaApod (
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)