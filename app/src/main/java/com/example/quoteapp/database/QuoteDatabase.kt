package com.example.quoteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quoteapp.models.QuoteDBModel

@Database(entities = [QuoteDBModel::class], version = 3, exportSchema = false)
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
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}