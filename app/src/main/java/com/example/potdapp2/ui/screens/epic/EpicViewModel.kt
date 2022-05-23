package com.example.potdapp2.ui.screens.epic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potdapp2.api.EpicPictureResponse
import com.example.potdapp2.api.PictureOfTheDayResponse
import com.example.potdapp2.domain.NasaRepository
import com.example.potdapp2.domain.NasaRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EpicViewModel(private val repository: NasaRepository) : ViewModel() {

    val epicPicture: MutableLiveData<List<EpicPictureResponse>> = MutableLiveData()

    fun requestEpicPicture() {

        viewModelScope.launch(Dispatchers.IO) {

            epicPicture.postValue(repository.epicPicture())
        }
    }
}