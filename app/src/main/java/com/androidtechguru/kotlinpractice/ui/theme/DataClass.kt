package com.androidtechguru.kotlinpractice.ui.theme

fun main(){
    UserData("Nikhil").run()
}

data class UserData(val name:String){
    fun run() {
        println("run fun-> $name")
    }
}