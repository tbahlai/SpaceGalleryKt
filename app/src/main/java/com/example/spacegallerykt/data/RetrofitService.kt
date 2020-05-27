package com.example.spacegallerykt.data

import com.example.spacegallerykt.BuildConfig
import com.example.spacegallerykt.data.api.ApiKeyInterceptor
import com.example.spacegallerykt.data.api.NasaApi
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.*

class RetrofitService {

    fun getClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(ApiKeyInterceptor())
        if (!BuildConfig.BUILD_TYPE.contains("release")) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        val client = builder.build()
        return client
    }

    val retrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NasaApi::class.java)
    }
}