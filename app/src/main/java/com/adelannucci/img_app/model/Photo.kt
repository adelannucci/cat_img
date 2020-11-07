package com.adelannucci.img_app.model

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: String,
    @SerializedName("is_album")
    val isAlbum: Boolean,
    val cover: String,
    val link: String
)