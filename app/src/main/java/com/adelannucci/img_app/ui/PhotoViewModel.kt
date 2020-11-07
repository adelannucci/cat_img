package com.adelannucci.img_app.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adelannucci.img_app.network.PhotoRepository

class PhotoViewModel: ViewModel() {
    private var page = 0
    private var repository: PhotoRepository = PhotoRepository()

    init {
        Log.i("PhotoViewModel", "PhotoViewModel created!")
        repository = PhotoRepository()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("PhotoViewModel", "PhotoViewModel destroyed!")
    }

    fun loadImages(): LiveData<List<String>> {
        page++
        return repository.fetch(page)
    }
}