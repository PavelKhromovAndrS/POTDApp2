package com.example.potdapp2

import com.example.potdapp2.domain.NasaRepository
import com.example.potdapp2.domain.NasaRepositoryImpl
import com.example.potdapp2.ui.screens.potd.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  appModule = module{
    single<NasaRepository> { NasaRepositoryImpl() }

    //View models
    viewModel { MainViewModel(get()) }
}