package com.example.potdapp2.ui.screens.potd

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import coil.load
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentMainBinding
import com.example.potdapp2.ui.MainActivity
import com.example.potdapp2.ui.ThemeOne
import com.example.potdapp2.ui.ThemeSecond
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.requestPictureOfTheDay()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)

        viewModel.pictureOfTheDay.observe(viewLifecycleOwner, Observer {
                    binding.img.load(it?.url)
                    binding.tvDescription.text = it?.title

        })

    }

}