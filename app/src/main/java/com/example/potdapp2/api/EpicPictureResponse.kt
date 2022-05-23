package com.example.potdapp2.api

import com.google.gson.annotations.SerializedName

data class EpicPictureResponse(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("version")
    val version: String,
    @SerializedName("date")
    val date: String,
)