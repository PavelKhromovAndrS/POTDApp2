package com.example.potdapp2

import com.example.potdapp2.api.PictureOfTheDayResponse

sealed class AppState{
    data class SuccessPopular(val pictureOfTheDay:PictureOfTheDayResponse?) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()

}
