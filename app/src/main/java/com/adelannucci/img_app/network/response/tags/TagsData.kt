package com.adelannucci.img_app.network.response.tags

import com.adelannucci.img_app.network.response.common.Gallery
import com.adelannucci.img_app.network.response.common.Tag
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TagsData {
    @SerializedName("tags")
    @Expose
    var tags: List<Tag>? = null

    @SerializedName("featured")
    @Expose
    var featured: String? = null

    @SerializedName("galleries")
    @Expose
    var galleries: List<Gallery>? = null

}
