package com.example.currencyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.annotation.RestrictTo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyapi.databinding.ActivityMainBinding
import com.example.currencyapi.models.Quote
import com.example.currencyapi.service.RetrofitApi
import com.example.currencyapi.service.RetrofitInstance
import com.example.currencyapi.utils.Constants.TAG
import com.example.currencyapi.view.QuoteViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }




}
