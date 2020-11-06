package com.adelannucci.img_app.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoApi {
//    @GET("/3/gallery/search/{page}/?q=title:cats")
//    fun getProperties(@Path("page") page: Int): Call<PhotoData>

    @GET("/3/gallery/search/{page}/?q=cats")
    fun getProperties(@Path("page") page: Int,
                      @Query("q") q: String): Call<PhotoData>

}