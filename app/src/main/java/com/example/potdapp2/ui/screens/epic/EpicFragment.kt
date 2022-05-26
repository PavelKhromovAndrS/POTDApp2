package com.example.potdapp2.ui.screens.epic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import coil.load
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentEpicBinding
import coil.load
import com.example.potdapp2.ui.API_KEY
import com.example.potdapp2.ui.screens.potd.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpicFragment : Fragment(R.layout.fragment_epic) {

    private val viewModel: EpicViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.requestEpicPicture()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEpicBinding.bind(view)

        viewModel.epicPicture.observe(viewLifecycleOwner, Observer {

            val strDate = it.last().date.split(" ").first()
            val image = it.last().image
            val url = "https://api.nasa.gov/EPIC/archive/natural/" +
                    strDate.replace("-", "/", true) +
                    "/png/" +
                    "$image" +
                    ".png?api_key=$API_KEY"
            binding.epicImage.load(url)
            binding.epicTv.text = it[1].caption
        })
        binding.btn.setOnClickListener {
            binding.container.transitionToEnd()
        }
    }
}
