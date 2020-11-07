package com.adelannucci.img_app.source.remote

import com.adelannucci.img_app.model.PhotoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoDataSource {
    @GET("/3/gallery/search/{page}/?")
    fun getProperties(@Path("page") page: Int,
                      @Query("q") q: String): Call<PhotoData>
}