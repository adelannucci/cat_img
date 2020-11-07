package com.adelannucci.img_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.adelannucci.img_app.R
import com.adelannucci.img_app.ui.photo.PhotoGridAdapter
import com.adelannucci.img_app.ui.photo.PhotoViewModel

class MainActivity : AppCompatActivity() {

    private val adapter = PhotoGridAdapter(this)
    private var recyclerView: RecyclerView? = null
    var viewModel: PhotoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.photos)
        recyclerView?.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.adapter = adapter

        viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)
        viewModel?.loadImages()?.observe(this, Observer { list ->
            adapter.updateList(list)
        })

        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {

                    val visibleItemCount = this@MainActivity.recyclerView?.childCount ?: 0
                    val totalItemCount = adapter.itemCount

                    val firstVisibleItems: IntArray = (this@MainActivity.recyclerView?.layoutManager
                            as StaggeredGridLayoutManager).findFirstVisibleItemPositions(null)

                    val pastVisibleItems = if (firstVisibleItems.isNotEmpty()) {
                        firstVisibleItems.first()
                    } else {
                        0
                    }

                    if ((visibleItemCount + pastVisibleItems >= totalItemCount)) {
                        viewModel?.loadImages()
                    }
                }
            }
        })
    }
}