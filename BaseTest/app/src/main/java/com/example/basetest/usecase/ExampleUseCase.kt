package com.example.basetest.usecase

import com.example.basetest.error.ErrorException
import kotlinx.coroutines.*

class ExampleUseCase {
    suspend fun test(scope: CoroutineScope) {
        val result =  scope.async{

        }
        result.await()
        withContext(Dispatchers.IO) {

        }
    }

    operator fun invoke() {
        throw ErrorException.Network
    }

    // or
    operator fun invoke(
        scope: CoroutineScope,
        coroutineExceptionHandler: CoroutineExceptionHandler
    ) {
        scope.launch(coroutineExceptionHandler) {
            throw ErrorException.Network
        }
    }
}