package com.example.currencyapi.models

import androidx.room.Entity

@Entity(tableName = "quote")
data class Quote(
    var id: Int,
    var languageCode : String,
    var content : String,
    var url: String,
    var  originator: Originator

)
