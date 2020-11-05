package com.adelannucci.img_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.adelannucci.img_app.network.Photo
import com.adelannucci.img_app.network.PhotoData
import com.adelannucci.img_app.network.RetrofitInitializer
import com.adelannucci.img_app.ui.ImageGridAdapter
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv : RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)


        val call = RetrofitInitializer().PhotoService().getProperties(1)
        call.enqueue(object : Callback<PhotoData?> {
            override fun onResponse(call: Call<PhotoData?>, response: Response<PhotoData?>) {
                response?.body()?.let {
                    val imgs = it
                }
            }

            override fun onFailure(call: Call<PhotoData?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })


        val imageList = ArrayList<String>()
        imageList.add("https://thumbs.dreamstime.com/b/halloween-cat-wearing-pointed-witches-hat-sitting-amongst-pumpkins-doorstep-rustic-cabin-blue-door-101483600.jpg")
        imageList.add("https://thumbs.dreamstime.com/b/cute-red-cat-cardboard-box-background-wooden-planks-close-up-88881992.jpg")
        imageList.add("https://thumbs.dreamstime.com/b/pet-cat-green-cats-eyes-gray-big-102425920.jpg")
        imageList.add("https://thumbs.dreamstime.com/b/cat-eyes-835113.jpg")
        imageList.add("https://thumbs.dreamstime.com/b/cat-playing-toy-young-tabby-wit-mouse-97067866.jpg")
        imageList.add("https://thumbs.dreamstime.com/b/young-kitten-cat-meowing-green-grass-funny-97243585.jpg")
        imageList.add("https://thumbs.dreamstime.com/b/portrait-funny-cat-fly-his-nose-portrait-funny-cat-fly-his-nose-isolated-white-background-125606127.jpg")

        rv.adapter = ImageGridAdapter(this, imageList)
    }
}