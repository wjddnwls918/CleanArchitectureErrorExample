package com.example.basetest

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.basetest.base.BaseViewModel
import com.example.basetest.error.ErrorException
import kotlinx.coroutines.launch
import java.io.IOException

// presentation layer module
class MainViewModel(application: Application) :BaseViewModel(application) {
    fun apiTest() {
        viewModelScope.launch(coroutineExceptionHandler) {
//            throw IOException()
            throw ErrorException.Network
        }
    }
}