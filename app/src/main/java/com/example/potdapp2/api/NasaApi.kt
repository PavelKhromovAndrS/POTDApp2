package com.example.potdapp2.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("planetary/apod")
    suspend fun pictureOfTheDay(@Query("api_key") key: String): PictureOfTheDayResponse

    @GET("EPIC/api/natural")
    suspend fun epicPicture(
        @Query("api_key") key: String,
    ): List<EpicPictureResponse>
}