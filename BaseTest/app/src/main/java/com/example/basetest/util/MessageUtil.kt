package com.example.basetest.util

import android.content.Context
import android.widget.Toast

object MessageUtil {
    fun showDefaultToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}