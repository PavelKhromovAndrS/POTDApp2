package com.example.potdapp2.ui.screens.potd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.potdapp2.api.PictureOfTheDayResponse
import com.example.potdapp2.domain.NasaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel(private val repository: NasaRepository) : ViewModel() {

    val pictureOfTheDay: MutableLiveData<PictureOfTheDayResponse?> = MutableLiveData()

    fun requestPictureOfTheDay() {

        viewModelScope.launch(Dispatchers.IO) {

            pictureOfTheDay.postValue(repository.pictureOfTheDay())
        }
    }
}
