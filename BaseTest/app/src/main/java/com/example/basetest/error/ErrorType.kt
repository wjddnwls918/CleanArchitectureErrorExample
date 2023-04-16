package com.example.basetest.error

// common layer module
sealed class ErrorType {
    object Common : ErrorType()
    object Network : ErrorType()
    object Unknown : ErrorType()
}