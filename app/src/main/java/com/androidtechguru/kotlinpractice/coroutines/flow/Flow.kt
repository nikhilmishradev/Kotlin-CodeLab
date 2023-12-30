package com.androidtechguru.kotlinpractice.coroutines.flow

import com.androidtechguru.kotlinpractice.oops.classes.Loading
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    Loading.showLoading(true)

    fetchFlowData()
        .onStart {

        }
        .onCompletion {

        }
        .onEach {

        }
        .map { it * 1 }
        .collect { value ->
            println(value)
        }

    Loading.showLoading(false)
    println("Disconnection...")
}

fun fetchFlowData(): Flow<Int> = flow {
    println("00000")
    for (i in 1..5) {
        delay(500L)
        emit(i)
    }
    println("999999")
}

