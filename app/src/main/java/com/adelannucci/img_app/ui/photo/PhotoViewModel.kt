package com.adelannucci.img_app.ui.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adelannucci.img_app.source.PhotoRepository

class PhotoViewModel: ViewModel() {
    private var page = 0
    private var repository: PhotoRepository = PhotoRepository()

    fun loadImages(): LiveData<List<String>> {
        page++
        return repository.fetch(page)
    }
}