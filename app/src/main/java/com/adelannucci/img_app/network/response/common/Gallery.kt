package com.adelannucci.img_app.network.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Gallery {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("topPost")
    @Expose
    var topPost: TopPost? = null

}