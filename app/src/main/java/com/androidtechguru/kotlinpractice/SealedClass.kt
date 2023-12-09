package com.androidtechguru.kotlinpractice


fun main() {
    val result: Result = Success("")
    processResult(result)
}

fun processResult(result: Result) {
    when (result) {
        is Success -> {
            println("Success: ${result.data}")
        }

        is Failure -> {
            println("Failure: ${result.message}")
        }

        Loading -> {
            Loading.showLoading()
        }
        is Output -> {}
        is Internet -> println("Internet: ${result.wifi}")
    }
}

sealed class Result {
}
   class Success(val data: String = "Success") : Result()
    class Failure(val message: String = "Failure") : Result()

    object Loading : Result() {

        fun showLoading(isLoading: Boolean = false) = run {
            if(isLoading) println("loading object Progress...") else println("loading object Cancelled...")}

    }


