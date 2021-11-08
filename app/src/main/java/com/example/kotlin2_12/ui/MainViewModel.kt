package com.example.kotlin2_12.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var counter = MutableLiveData<Int>()
    private var count = 0

    fun setCount() {
        count++
        counter.postValue(count)
    }

    fun getCount(): MutableLiveData<Int> {
        return counter
    }

}