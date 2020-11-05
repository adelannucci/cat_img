package com.adelannucci.img_app.network.response.galleries

import com.adelannucci.img_app.network.response.common.Tag
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GalleriesTagRoot {
    @SerializedName("data")
    @Expose
    var data: Tag? = null

    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

}
