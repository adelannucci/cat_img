package com.adelannucci.img_app.network.response.images

import com.adelannucci.img_app.network.response.common.Image
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageData {
    @get:SerializedName("data")
    @Expose
    var data: Image? = null

}
