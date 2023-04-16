package com.example.basetest.error

import android.util.Log

// 뷰단에서 사용자에게 어떠한 방식으로 에러를 보여줄지 결정
// 현재는 로그로 찍었지만, 토스트 스낵바 혹은 모달등으로 분기해야할듯
object ErrorHandler {
    fun handleErrorByErrorType(errorType: ErrorType) {
        when(errorType) {
            is ErrorType.Success -> {
                Log.d("ErrorType.Common", "성공이야")
            }
            is ErrorType.Common -> {
                Log.d("ErrorType.Common", "ErrorType.Common 입니다")
            }
            is ErrorType.Network -> {
                Log.d("ErrorType.Network", "ErrorType.Network 입니다")
            }
        }
    }
}