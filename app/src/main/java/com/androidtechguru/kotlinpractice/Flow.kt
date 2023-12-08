package com.androidtechguru.kotlinpractice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine

fun main() = runBlocking {
    fetchData()
        .map { it * 2 }
        .collect { value ->
            println(value)
        }
}

fun fetchData(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000L)
        emit(i)
    }
}
