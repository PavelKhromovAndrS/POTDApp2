package com.example.potdapp2.domain

import com.example.potdapp2.api.PictureOfTheDayResponse

interface NasaRepository {
    suspend fun pictureOfTheDay(): PictureOfTheDayResponse
}