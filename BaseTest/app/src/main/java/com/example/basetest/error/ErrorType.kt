package com.example.basetest.error

sealed class ErrorType {
    object Success : ErrorType()
    object Common : ErrorType()
    object Network : ErrorType()
}