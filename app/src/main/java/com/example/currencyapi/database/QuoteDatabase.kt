package com.example.currencyapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.currencyapi.models.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDAO

    companion object{
        private var instance: QuoteDatabase?= null

        fun getQuoteDb(context: Context): QuoteDatabase?{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context,
                    QuoteDatabase::class.java,
                    "student.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}