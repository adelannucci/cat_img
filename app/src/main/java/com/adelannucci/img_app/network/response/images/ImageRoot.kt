package com.adelannucci.img_app.network.response.images

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageRoot {
    @SerializedName("data")
    @Expose
    var imageData: ImageData? = null

    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

}