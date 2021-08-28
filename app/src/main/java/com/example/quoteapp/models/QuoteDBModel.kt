package com.example.quoteapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quote")
data class QuoteDBModel(
    @PrimaryKey
    @SerializedName("id")
    var quoteId: Long,
    var languageCode: String?,
    var content: String,
    @SerializedName("url")
    var quoteUrl: String?,
    var author: String
)
