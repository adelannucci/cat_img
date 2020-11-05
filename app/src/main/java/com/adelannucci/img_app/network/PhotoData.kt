package com.adelannucci.img_app.network



data class PhotoData(
        val data: List<Photo>)


data class Photo(val id: String,
                 val link: String)