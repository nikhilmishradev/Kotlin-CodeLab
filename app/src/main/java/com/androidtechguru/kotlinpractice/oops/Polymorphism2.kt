package com.androidtechguru.kotlinpractice.oops

fun main() {
    Movie().play()
    Video().play()
    Music().play()
    Movie().download()
    Movie().data()
    "nikhil".run{

    }
}

open class Movie() : Stream {

     open fun data() {}
    override fun play() {
        println("${this.javaClass.simpleName} : play()")
    }

    override fun download() {
        println("${this.javaClass.simpleName} : download()")
    }

}

class Video : Movie(), Stream {
    override fun data(){}
    override fun download() {
        println("${this.javaClass.simpleName} : download()")
    }
}

class Music : Movie(), Stream {
    override fun play() {
        super.download()
        println("${this.javaClass.simpleName} : play()")
    }

    override fun download() {
        println("${this.javaClass.simpleName} : download()")

    }
}

interface Stream {
    fun play()
    fun download()

    fun stream() {
        println("${this.javaClass.simpleName} : stream()...")
    }
}