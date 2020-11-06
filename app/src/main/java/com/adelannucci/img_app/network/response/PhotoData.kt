package com.adelannucci.img_app.network.response

import com.google.gson.annotations.SerializedName


data class PhotoData(
    val data: List<Photo>
)

data class Photo(
    val id: String,
    @SerializedName("is_album")
    val isAlbum: Boolean,
    val cover: String,
    val link: String
)