package com.example.kotlin2_12.core

import android.app.Application
import com.example.kotlin2_12.data.remote.RetrofitClient
import com.example.kotlin2_12.data.remote.TriviaApi

class App : Application() {

    companion object {
        val client = RetrofitClient.create()
    }


}