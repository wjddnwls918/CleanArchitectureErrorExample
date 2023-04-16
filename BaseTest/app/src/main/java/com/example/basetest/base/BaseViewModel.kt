package com.example.basetest.base

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basetest.common.Event
import com.example.basetest.error.ErrorException
import com.example.basetest.error.ErrorType
import kotlinx.coroutines.CoroutineExceptionHandler

// presentation layer module
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val _errorEvent = MutableLiveData<Event<ErrorType>>()
    val errorEvent: LiveData<Event<ErrorType>>
        get() = _errorEvent

    //에러 캐치
    open val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("### context check", "coroutine context : $coroutineContext")
        Log.d("error arrived", "error : $throwable")
        // 예외에 따라 에러유형 설정
        when (throwable) {
            is ErrorException.Common -> {
                _errorEvent.value = Event(ErrorType.Common)
            }
            is ErrorException.Network -> {
                _errorEvent.value = Event(ErrorType.Network)
            }
            else -> {
                _errorEvent.value = Event(ErrorType.Unknown)
            }
        }
    }
}