package com.androidtechguru.kotlinpractice.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.random.Random


val job = CoroutineScope(Dispatchers.IO).launch {  }
val deferred = CoroutineScope(Dispatchers.IO).async {  }
fun main() = runBlocking {
    asyncTask()
    println("main()...")
}
suspend fun asyncTask() {
    withContext(Dispatchers.Default) {
//        MainScope().launch {  }

        val deferredJob1 = async(Dispatchers.Default) {
            println("async Task1")
            delay(2000)
            println("async Task1: delay()")
        }
        val deferredJob2 = async {
            println("async Task2")
        }
        val deferredJob3 = async {
            println("async Task3")
            delay(2000)
        }

        withContext(Dispatchers.IO) {
            launch {
                println("launch{ }")
                try {
                    throw Exception("launch{ } Custom Exception...")
                } catch (e: Exception) {
                    println("catch launch{} exception...")
                }
            }
        }

        val deferredJob4: Deferred<Int> = async {
            println("async Task4")
            delay(2000)
            println("async Task4: delay()")
            Random.nextInt(100)
        }
        val deferredJob5 = async {
            println("async Task5")
        }
        println(deferredJob4)
    }
}

suspend fun task() {
    withContext(Dispatchers.Default) {
        val job = launch {
            delay(1000L)
            println(
                "Coroutine executed: "
            )
            Thread.currentThread().name
        }

        println("Hello")
        job.join()
        println("World")
        val async = async {
            println("IO: ${Thread.currentThread().name} Thread")
            delay(3000L)
            10
        }
        println("Before await()")
        async.await()
        println("After await()")
        println("async: $async -> result: ${async.await()}")
    }
}

val value: Any = 0