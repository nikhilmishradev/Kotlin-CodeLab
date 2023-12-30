package com.androidtechguru.kotlinpractice.coroutines

import kotlinx.coroutines.*

suspend fun firstFunction() {
    println("1 started...")
    delay(1000)
    println("First function completed")
}

suspend fun secondFunction() {
    println("2 started...")
    delay(1000L)
    println("Second function completed")
}

suspend fun thirdFunction() {
    println("3 started...")
    delay(1000)
    println("Third function completed")
}

fun main() {
    println("Before calling suspend functions")

    runBlocking {
        launch {
            firstFunction()
        }
        launch {
            secondFunction()
        }
        launch {
            thirdFunction()
        }
    }

    println("END")
}
