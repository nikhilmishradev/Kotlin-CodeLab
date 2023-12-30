package com.androidtechguru.kotlinpractice.coroutines

import com.androidtechguru.kotlinpractice.coroutines.flow.fetchFlowData
import com.androidtechguru.kotlinpractice.oops.classes.Loading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

data class User(val name: String)

fun main() = runBlocking {
    Loading.showLoading(true)
    performConcurrentTask()
    var result = fetchData().also {
        Loading.showLoading(false)
    }
    println(result)
}

suspend fun fetchData(): String {
    delay(2000L)
    coroutineA()
    return "Data fetched..."
}

suspend fun coroutineA() {
    GlobalScope.launch(Dispatchers.IO) {
        val user = fetchUser()
        println("User Data from API response: $user")
        fetchFlowData().collect {
            println("Collect Flow...")
        }
    }
}

suspend fun fetchUser(): User {
    return withContext(Dispatchers.IO) {
        User("Nikhil Mishra")
    }
}

suspend fun performConcurrentTask() {
    val result1 = withContext(Dispatchers.IO) {
        async {
            var task1 = 0
            for (i in 1..4) {
                delay(1000L)
                runBlocking {
                    println("async: $i -> Task1")
                    task1 = i
                }
            }
            return@async task1
        }
    }
    yield()         // suspending function() --->>> delay() is another suspending function
    val result2 = withContext(Dispatchers.IO) {
        async {
            var task2 = 0
            for (i in 1..3) {
                delay(1000L)
                runBlocking {
                    println("async: $i -> Task2")
                    task2 = i
                }
            }
            task2
        }
    }
    val finalResult = result1.await() + result2.await()
    println(finalResult)

    var ok = withContext(Dispatchers.IO){

    }
}

object TAG{
    const val verbose ="VERBOSE"
    const val coroutine="COROUTINES"
}