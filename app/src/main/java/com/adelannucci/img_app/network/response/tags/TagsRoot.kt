package com.adelannucci.img_app.network.response.tags

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TagsRoot {
    @SerializedName("data")
    @Expose
    var tagsData: TagsData? = null

    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

}