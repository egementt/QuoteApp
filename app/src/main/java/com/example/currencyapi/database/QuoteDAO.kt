package com.example.currencyapi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.currencyapi.models.Quote

@Dao
interface QuoteDAO {

    @Insert
    fun insert(quote: Quote)

    @Query("SELECT*FROM quote")
    fun getAllQuote(): ArrayList<Quote>
}