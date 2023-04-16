package com.example.basetest.error

// 커스텀 예외
// common layer module
sealed class ErrorException: Exception() {
    object Common: ErrorException()
    object Network: ErrorException()
}