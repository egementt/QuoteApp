package com.example.quoteapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quoteapp.models.Quote
import com.example.quoteapp.service.RetrofitApi
import com.example.quoteapp.service.RetrofitInstance
import com.example.quoteapp.utils.Constants.TAG
import retrofit2.HttpException

class QuoteViewModel : ViewModel() {

    var retrofit : RetrofitApi = RetrofitInstance.retrofitInstance

    val liveQuote: MutableLiveData<Quote> = MutableLiveData<Quote>()



    suspend fun getQuote() {
        try {
            liveQuote.postValue(retrofit.getQuote())
        }catch ( exception:HttpException){
            Log.d(TAG, exception.message())
        }
    }



}