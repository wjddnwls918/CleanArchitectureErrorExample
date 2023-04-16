package com.example.basetest.base

import androidx.appcompat.app.AppCompatActivity
import com.example.basetest.error.ErrorHandler

// presentation layer module
abstract class BaseActivity <R : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: R
    open fun initErrorObserve() {
        viewModel.errorEvent.observe(
            this
        ) {
            it.getContentIfNotHandled()?.let { errorType ->
                ErrorHandler.handleErrorByErrorType(errorType)
            }
        }
    }
}