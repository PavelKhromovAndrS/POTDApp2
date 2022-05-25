package com.example.potdapp2.ui.screens.settings

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentMainBinding
import com.example.potdapp2.databinding.FragmentSettingsBinding
import com.example.potdapp2.ui.MainActivity
import com.example.potdapp2.ui.ThemeOne
import com.example.potdapp2.ui.ThemeSecond


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var parentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity =
            requireActivity() as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSettingsBinding.bind(view)

        binding.buttonTheme1.setOnClickListener(View.OnClickListener {
            parentActivity.setCurrentTheme(ThemeOne)
            parentActivity.recreate()
        })

        binding.buttonTheme2.setOnClickListener(View.OnClickListener {
            parentActivity.setCurrentTheme(ThemeSecond)
            parentActivity.recreate()
        })
        binding.fabButton.setOnClickListener {
            Toast.makeText(requireContext(), "Advanced settings", Toast.LENGTH_SHORT).show()
        }
    }
}