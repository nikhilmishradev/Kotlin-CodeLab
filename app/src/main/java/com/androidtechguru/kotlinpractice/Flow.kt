package com.androidtechguru.kotlinpractice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    Loading.showLoading(true)
    fetchFlowData()
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

class Output : Result() {
    fun printOutput() {
        println("Output object...")
    }
}
