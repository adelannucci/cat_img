package com.adelannucci.img_app.network.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("datetime")
    @Expose
    var datetime: Int? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("animated")
    @Expose
    var animated: Boolean? = null

    @SerializedName("width")
    @Expose
    var width: Int? = null

    @SerializedName("height")
    @Expose
    var height: Int? = null

    @SerializedName("size")
    @Expose
    var size: Int? = null

    @SerializedName("views")
    @Expose
    var views: Int? = null

    @SerializedName("vote")
    @Expose
    var vote: Any? = null

    @SerializedName("favorite")
    @Expose
    var favorite: Boolean? = null

    @SerializedName("nsfw")
    @Expose
    var nsfw: Any? = null

    @SerializedName("section")
    @Expose
    var section: Any? = null

    @SerializedName("account_url")
    @Expose
    var accountUrl: Any? = null

    @SerializedName("account_id")
    @Expose
    var accountId: Any? = null

    @SerializedName("is_ad")
    @Expose
    var isAd: Boolean? = null

    @SerializedName("in_most_viral")
    @Expose
    var inMostViral: Boolean? = null

    @SerializedName("tags")
    @Expose
    var tags: List<Tag>? =
        null

    @SerializedName("ad_type")
    @Expose
    var adType: Int? = null

    @SerializedName("ad_url")
    @Expose
    var adUrl: String? = null

    @SerializedName("in_gallery")
    @Expose
    var inGallery: Boolean? = null

    @SerializedName("mp4")
    @Expose
    var mp4: String? = null

    @SerializedName("gifv")
    @Expose
    var gifv: String? = null

    @SerializedName("mp4_size")
    @Expose
    var mp4Size: Int? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("looping")
    @Expose
    var looping: Boolean? = null

    @SerializedName("comment_count")
    @Expose
    var commentCount: Any? = null

    @SerializedName("ups")
    @Expose
    var ups: Any? = null

    @SerializedName("downs")
    @Expose
    var downs: Any? = null

    @SerializedName("points")
    @Expose
    var points: Any? = null

    @SerializedName("score")
    @Expose
    var score: Any? = null

    @Expose
    @SerializedName("is_album")
    var isAlbum: Boolean? = null

    @Expose
    @SerializedName("images")
    var images: List<Image>? = null

    @Expose
    @SerializedName("cover")
    var cover: String? = null

    @Expose
    @SerializedName("cover_width")
    var coverWidth = 0

    @Expose
    @SerializedName("cover_height")
    var coverHeight = 0

}