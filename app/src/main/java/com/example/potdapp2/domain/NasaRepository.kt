package com.example.potdapp2.domain

import com.example.potdapp2.api.EpicPictureResponse
import com.example.potdapp2.api.PictureOfTheDayResponse

interface NasaRepository {
    suspend fun pictureOfTheDay(): PictureOfTheDayResponse

    suspend fun epicPicture(): List<EpicPictureResponse>

}