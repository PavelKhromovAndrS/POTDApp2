package com.example.potdapp2.ui.screens.notes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.potdapp2.R
import com.example.potdapp2.databinding.FragmentNotesBinding
import com.example.potdapp2.ui.MainActivity

const val ARG_KEY = "ARG_KEY"
const val ARG_KEY2 = "ARG_KEY2"

class NotesFragment : Fragment(R.layout.fragment_notes), Listener {

    private val adapter = NotesAdapter(this, MainActivity.notes)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNotesBinding.bind(view)
        val notesList: RecyclerView = binding.rvNotes
        val addNote: Button = binding.addButton
        val addNoteEditText: EditText = binding.addEditText
        notesList.adapter = adapter

        with(adapter) {
            addNote.setOnClickListener {
                notesData.add(NotesData((itemCount).toString(), addNoteEditText.text.toString()))
                notifyItemInserted(itemCount)
            }

        }
        ItemTouchHelper(ItemTouchHelperCallBack {
            adapter.itemRemoved(it)
        }).attachToRecyclerView(notesList)
    }

    override fun onClickRemove(notesData: NotesData) {
        adapter.notesData.remove(notesData)
    }

    override fun onClickEdit(notesData: NotesData, pos: Int) {

        parentFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.nav_host_fragment, EditNoteFragment.newInstance(Bundle().apply {
                putParcelable(ARG_KEY, notesData)
                putInt(ARG_KEY2,pos)
            }))
            .commit()
    }
}
