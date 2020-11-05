package com.adelannucci.img_app.network

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApi {
    @GET("/3/gallery/search/{page}/?q=cats")
    fun getProperties(@Path("page") page: Int): Call<PhotoData>

}