package com.example.potdapp2.domain

import com.example.potdapp2.api.EpicPictureResponse
import com.example.potdapp2.api.NasaApi
import com.example.potdapp2.api.PictureOfTheDayResponse
import com.example.potdapp2.ui.API_KEY
import com.example.potdapp2.ui.BASE_URL
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaRepositoryImpl : NasaRepository {

    private val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
            .build()
        )
        .build()
        .create(NasaApi::class.java)

    override suspend fun pictureOfTheDay(): PictureOfTheDayResponse = api.pictureOfTheDay(API_KEY)


    override suspend fun epicPicture(): List<EpicPictureResponse> = api.epicPicture(API_KEY)

}



