package com.adelannucci.img_app.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.adelannucci.img_app.network.response.PhotoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository {

    private var photos: MutableLiveData<List<String>> = MutableLiveData()

    fun fetch(page: Int): MutableLiveData<List<String>> {
        val call = RetrofitInitializer().PhotoService().getProperties(page, "cats")
        call.enqueue(object : Callback<PhotoData?> {
            override fun onResponse(call: Call<PhotoData?>, response: Response<PhotoData?>) {
                response.body()?.let { item: PhotoData ->
                    val imageList = ArrayList<String>()
                    imageList.addAll(item.data.map {
                        val id = if (it.isAlbum) {
                            it.cover
                        } else {
                            it.id
                        }
                        "https://i.imgur.com/$id.jpg"
                    })
                    photos.value = imageList
                }
            }

            override fun onFailure(call: Call<PhotoData?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })

        return photos
    }
}