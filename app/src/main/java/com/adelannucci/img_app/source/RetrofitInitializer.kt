package com.adelannucci.img_app.source

import com.adelannucci.img_app.source.remote.PhotoDataSource
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val url = "https://api.imgur.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(interceptor())
        .build()

    private fun interceptor(): OkHttpClient? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor { chain ->
            val originalRequest: Request = chain.request()
            val builder: Request.Builder = originalRequest.newBuilder().header(
                "Authorization",
                "Client-ID 3df4d37a2a3d85c"
            )
            val newRequest: Request = builder.build()
            chain.proceed(newRequest)
        }.addInterceptor(logging).build()
    }

    fun PhotoService(): PhotoDataSource = retrofit.create(PhotoDataSource::class.java)
}