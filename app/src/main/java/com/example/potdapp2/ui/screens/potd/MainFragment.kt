package com.example.potdapp2.ui.screens.potd

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.transition.*
import coil.load
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentMainBinding
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

        viewModel.pictureOfTheDay.observe(viewLifecycleOwner, {
            binding.apodImage.load(it?.url)
            val spannable = SpannableString(it?.title)
            it?.title?.length?.let { it1 ->
                spannable.setSpan(ForegroundColorSpan(Color.BLUE),0,
                    it1,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }


            binding.tvDescription.text = spannable
            binding.tvExplanation.text = it?.explanation

        })

        val text = binding.tvShowHide.text


        var isTextVisible = false

        binding.tvShowHide.setOnClickListener {

            isTextVisible = isTextVisible.not()

            TransitionManager.beginDelayedTransition(binding.root, Slide(Gravity.START))

            val group: Group = binding.group

            if (isTextVisible) {
                group.visibility = View.GONE
            } else {
                group.visibility = View.VISIBLE
            }
        }

        var isExpanded = false

        val img: ImageView = binding.apodImage

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