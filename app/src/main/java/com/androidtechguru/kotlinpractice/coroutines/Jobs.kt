package com.androidtechguru.kotlinpractice.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        jobTask()
        launch(Dispatchers.Default) {
            println(coroutineContext)
        }
    }
}

suspend fun jobTask() {
    val parentJob = CoroutineScope(Dispatchers.Default).launch {
        println("Parent - $coroutineContext")

        // same context as parent has, it inherits the context
        val childJob1 = launch {
            println("Child1 - $coroutineContext")
            delay(1000)
        }
        childJob1.join()

        // context switching - a child can switch it's context
        val childJob2 = launch(Dispatchers.IO) {
            println("Child2 - $coroutineContext")
        }.join()

        val childJob3 = launch {
            println("Child3 - $coroutineContext")
        }
    }
}