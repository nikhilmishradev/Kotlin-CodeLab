package com.androidtechguru.kotlinpractice.oops

fun main() {
    val sam = SAM()
    sam.exe()
}

fun interface Execute {
    fun run(){
        println("SAM function: run()")
    }
    fun exe()
}

class SAM : Execute {

    override fun run() {

    }

    override fun exe() {

    }
}