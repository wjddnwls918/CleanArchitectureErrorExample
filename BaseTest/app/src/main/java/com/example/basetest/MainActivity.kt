package com.example.basetest

import android.os.Bundle
import androidx.activity.viewModels
import com.example.basetest.base.BaseActivity
import com.example.basetest.error.ErrorHandler

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 예외 처리 observe
        // BaseActivity에서 Observe하려 했으나 Base에서는 ViewModel에 있는 라이브데이터 생성되지 않아서
        // 구독이 안되는거 같습니다. 각 뷰에서 뷰모델의 errorEvent를 구독하는 형식으로 가야할듯
        initErrorObserve()
        //에러발생
        viewModel.apiTest()
    }


    private fun initErrorObserve() {
        viewModel.errorEvent.observe(
            this
        ) {
            it.getContentIfNotHandled()?.let { errorType ->
                ErrorHandler.handleErrorByErrorType(errorType)
            }
        }
    }
}