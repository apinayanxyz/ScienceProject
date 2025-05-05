package com.example.scienceproject.ui.dailytest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DailyTestViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Daily test Fragment"
    }
    val text: LiveData<String> = _text
}