package com.example.currencyapi.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyapi.models.Quote
import com.example.currencyapi.service.RetrofitApi
import com.example.currencyapi.service.RetrofitInstance
import com.example.currencyapi.utils.Constants.TAG
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