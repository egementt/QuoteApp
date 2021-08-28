package com.example.quoteapp.models


data class Originator(
    var id: Long,
    var name: String,
    var url: String,
    val parentId: Long

)
