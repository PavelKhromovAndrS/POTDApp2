package com.example.potdapp2.ui.screens.notes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NotesData(val id: String, var description: String) : Parcelable
