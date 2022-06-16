package com.example.potdapp2.ui.screens.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.potdapp2.R

interface Listener {
    fun onClickRemove(notesData: NotesData)
    fun onClickEdit(notesData: NotesData, pos: Int)
}

class NotesAdapter(private val listener: Listener, data: MutableList<NotesData>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    var notesData = data


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder =
        NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        with(holder) {
            notesId.text = notesData[position].id
            notesDescription.text = notesData[position].description
            notesDelete.setOnClickListener {
                listener.onClickRemove(notesData[layoutPosition])
                notifyItemRemoved(layoutPosition)
            }
            notesEdit.setOnClickListener {
                listener.onClickEdit(notesData[layoutPosition], layoutPosition)
                notifyItemChanged(layoutPosition)
            }
        }

    }

    override fun getItemCount(): Int = notesData.size

    fun itemRemoved(position: Int) {
        notesData.removeAt(position)
        notifyItemRemoved(position)

    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notesDescription: TextView = itemView.findViewById(R.id.note_description)
        val notesId: TextView = itemView.findViewById(R.id.note_id)
        val notesDelete: ImageView = itemView.findViewById(R.id.delete_note)
        val notesEdit: ImageView = itemView.findViewById(R.id.edit_note)

    }
}