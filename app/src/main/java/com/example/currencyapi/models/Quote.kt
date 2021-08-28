package com.example.currencyapi.models

import com.google.gson.annotations.SerializedName


data class Quote(
    @SerializedName("id")
    var quoteId: Long,
    var languageCode: String?,
    var content: String,
    var quoteUrl: String?,
    var originator: Originator

)
