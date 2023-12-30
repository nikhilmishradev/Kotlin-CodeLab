package com.androidtechguru.kotlinpractice.oops

import kotlinx.coroutines.delay

suspend fun main() {
    println(firstClassFunction())
    println(greetingFunction("Nikhil"))
    println(internetStatus("Mobile", getInternetStatus(false)))
}

//Kotlin’s support for first-class functions means they can be assigned to variables, passed around as arguments, or returned from other functions.

// Example 1
fun firstClassFunction() = "This is first-class functions"
val assignFunction = ::firstClassFunction

// Example 2
fun greet(name: String) = "Hello, $name!..."
val greetingFunction: (String) -> String = ::greet


// Example 3
fun internet(name: String, status: Boolean) = "Internet is ${if(status) "ON" else "OFF"}: $name"
val internetStatus: (String, Boolean) -> String = ::internet

suspend fun getInternetStatus(isON:Boolean=false): Boolean {
    delay(1000)
    return isON
}