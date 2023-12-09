package com.androidtechguru.kotlinpractice

fun main() {
    UserData("Nikhil").run()
}

data class UserData(val name: String) {
    fun run() {
        println("run fun-> $name")
    }
}

open class Internet(var wifi: Boolean = true) : Result(){
    internal open class Wifi
    sealed class Mobile  : Result()

    internal data class New(val id:Int)

}
internal data class New(val id:Int)
