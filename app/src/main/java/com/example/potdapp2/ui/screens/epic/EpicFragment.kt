package com.example.potdapp2.ui.screens.epic

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import coil.load
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentEpicBinding
import com.example.potdapp2.ui.API_KEY
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

        viewModel.epicPicture.observe(viewLifecycleOwner, {

            val strDate = it.last().date.split(" ").first()
            val image = it.last().image
            val url = "https://api.nasa.gov/EPIC/archive/natural/" +
                    strDate.replace("-", "/", true) +
                    "/png/" +
                    image +
                    ".png?api_key=$API_KEY"
            binding.epicImage.load(url)
            binding.epicTv.text = it[1].caption
        })

        val tv: TextView = binding.epicTv

        var isTextVisible = false

        binding.btn.setOnClickListener {
            isTextVisible = isTextVisible.not()

            TransitionManager.beginDelayedTransition(binding.root)
            tv.visibility = if (isTextVisible) View.GONE else View.VISIBLE
        }

        var isExpanded = false

        val img: ImageView = binding.epicImage

        img.setOnClickListener {
            isExpanded = !isExpanded
            TransitionManager.beginDelayedTransition(
                binding.root, TransitionSet()
                    .addTransition(ChangeBounds())
                    .addTransition(ChangeImageTransform())
            )
            val params: ViewGroup.LayoutParams = img.layoutParams
            params.height =
                if (isExpanded) ViewGroup.LayoutParams.MATCH_PARENT else
                    ViewGroup.LayoutParams.WRAP_CONTENT
            img.layoutParams = params
            img.scaleType =
                if (isExpanded) ImageView.ScaleType.CENTER_CROP else
                    ImageView.ScaleType.FIT_CENTER
        }
    }
}
