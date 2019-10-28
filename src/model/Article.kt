package com.frangovers.petsociety.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Article(

    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("posted")
    @Expose
    var posted: Int? = null,
    @SerializedName("category")
    @Expose
    var category: String? = null,
    @SerializedName("data")
    @Expose
    var data: List<ArticleData>? = null

)