package com.yogeshlokhande.daggerdemo1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuoteResponse {
    @SerializedName("quote")
    @Expose
    var quote: String? = null

    @SerializedName("author")
    @Expose
    var author: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null
}