package com.frangovers.petsociety.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleData(

    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("content")
    @Expose
    var content: String? = null

)