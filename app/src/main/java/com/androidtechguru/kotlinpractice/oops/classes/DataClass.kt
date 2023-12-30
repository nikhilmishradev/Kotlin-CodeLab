package com.androidtechguru.kotlinpractice.oops.classes

fun main() {
    // Destructing Declaration
    //assign multiple values to variables from data stored in objects/arrays.
    val (name, id) = UserData("Doctor", 99)
    println("name: $name - id: $id")
}

data class UserData(val name: String, val id: Int = 0) {

    fun run() {
        println("run fun-> $name")

    }
}

