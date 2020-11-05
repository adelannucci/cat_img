package com.adelannucci.img_app.network.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tag {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("display_name")
    @Expose
    var displayName: String? = null

    @SerializedName("followers")
    @Expose
    var followers: Int? = null

    @SerializedName("total_items")
    @Expose
    var totalItems: Int? = null

    @SerializedName("following")
    @Expose
    var following: Boolean? = null

    @SerializedName("background_hash")
    @Expose
    var backgroundHash: String? = null

    @SerializedName("thumbnail_hash")
    @Expose
    var thumbnailHash: Any? = null

    @SerializedName("accent")
    @Expose
    var accent: String? = null

    @SerializedName("background_is_animated")
    @Expose
    var backgroundIsAnimated: Boolean? = null

    @SerializedName("thumbnail_is_animated")
    @Expose
    var thumbnailIsAnimated: Boolean? = null

    @SerializedName("is_promoted")
    @Expose
    var isPromoted: Boolean? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("logo_hash")
    @Expose
    var logoHash: Any? = null

    @SerializedName("logo_destination_url")
    @Expose
    var logoDestinationUrl: Any? = null

    @SerializedName("items")
    @Expose
    var items: List<Image>? =
        null

}
