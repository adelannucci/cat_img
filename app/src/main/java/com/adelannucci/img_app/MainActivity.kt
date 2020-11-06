package com.adelannucci.img_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.adelannucci.img_app.network.PhotoData
import com.adelannucci.img_app.network.RetrofitInitializer
import com.adelannucci.img_app.ui.ImageGridAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var page = 0
    private val adapter = ImageGridAdapter(this)
    private var rv: RecyclerView? = null
    private var loading = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.photos)
        rv?.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        rv?.adapter = adapter

        fetch()
        rv?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {

                    val visibleItemCount = rv?.childCount ?: 0
                    val totalItemCount = adapter.itemCount

                    val firstVisibleItems: IntArray =
                        (rv?.layoutManager as StaggeredGridLayoutManager).findFirstVisibleItemPositions(
                            null
                        )
                    val pastVisibleItems =
                        if (firstVisibleItems != null && firstVisibleItems.size > 0) {
                            firstVisibleItems[0]
                        } else {
                            0
                        }

                    if (!loading && (visibleItemCount + pastVisibleItems >= totalItemCount)) {
                        fetch()
                    }
                }
            }
        })
    }

    private fun fetch() {
        page += 1
        loading = true
        val call = RetrofitInitializer().PhotoService().getProperties(page, "cats")
        call.enqueue(object : Callback<PhotoData?> {
            override fun onResponse(call: Call<PhotoData?>, response: Response<PhotoData?>) {
                response?.body()?.let { item: PhotoData ->
                    val imageList = ArrayList<String>()
                    imageList.addAll(item.data.map {
                        val id = if (it.isAlbum) {
                            it.cover
                        } else {
                            it.id
                        }
                        "https://i.imgur.com/$id.jpg"
                    })
                    loading = false
                    adapter.updateList(imageList)
                }
            }

            override fun onFailure(call: Call<PhotoData?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
                loading = false
            }
        })
    }
}