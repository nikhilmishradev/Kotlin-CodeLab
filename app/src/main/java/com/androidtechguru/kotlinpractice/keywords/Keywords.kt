package com.androidtechguru.kotlinpractice.keywords


fun main() = run {
    val calculate = 999
    println("calculate minus: ${calculate minus 499}")
    inlineFun(10)
}

infix fun Int.minus(num: Int): Int {
    return this - num
}

inline fun inlineFun(id:Int){
    val text = "This is inline function body {}"
    println(text)
}

inline fun inlineFun(crossinline id:(Int)->Unit){
    id(40)
    val text = "This is inline function body {}"
    println(text)
}

fun interface Execute{
    fun run()
}