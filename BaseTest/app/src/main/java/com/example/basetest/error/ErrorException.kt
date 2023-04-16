package com.example.basetest.error

// 커스텀 예외
sealed class ErrorException: Exception() {
    object Common: ErrorException()
    object Network: ErrorException()
}