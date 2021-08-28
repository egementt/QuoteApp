package com.example.quoteapp.database

import androidx.room.*
import com.example.quoteapp.models.QuoteDBModel

@Dao
interface QuoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quote: QuoteDBModel)

    @Query("SELECT*FROM quote")
    @Transaction
    fun getAllQuote(): List<QuoteDBModel>
}