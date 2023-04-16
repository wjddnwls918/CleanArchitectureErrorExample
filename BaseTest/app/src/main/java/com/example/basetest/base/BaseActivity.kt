package com.example.basetest.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity <R : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: R
}