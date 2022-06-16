package com.example.potdapp2.ui.screens.notes

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentEditNoteBinding
import com.example.potdapp2.databinding.FragmentNotesBinding
import com.example.potdapp2.ui.MainActivity


class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEditNoteBinding.bind(view)
        val editNotes = binding.editNoteEditText

        arguments?.getParcelable<NotesData>(ARG_KEY).let {
            editNotes.setText(it?.description)
        }

        binding.editButton.setOnClickListener {
            MainActivity.notes[requireArguments().getInt(ARG_KEY2)].description =
                editNotes.text.toString()
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, NotesFragment())
                .commit()
        }
    }

    companion object {
        fun newInstance(bundle: Bundle) = EditNoteFragment().apply { arguments = bundle }
    }
}