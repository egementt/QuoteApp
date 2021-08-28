package com.example.currencyapi.service

import com.example.currencyapi.models.Quote
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RetrofitApi {

    @Headers(
        "x-rapidapi-host:quotes15.p.rapidapi.com",
        "x-rapidapi-key:c7e1caf395msh564d30b36bf0387p1e5c78jsna08efbc8312b"
    )
    @GET(".")
    suspend fun getQuote(): Quote


}