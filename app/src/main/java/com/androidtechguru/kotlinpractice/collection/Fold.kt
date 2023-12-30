package com.androidtechguru.kotlinpractice.collection

//Purpose — Performs an operation on elements of the collection, taking an initial accumulator value and a combining operation.
// It can work on collections of any type, not just numeric types.

fun main(){
    numberFold()
    stringFold()
}

fun numberFold(){
    val numberList = listOf(1,2,3,4)
    val sumStartingFrom10 = numberList.fold(10){acc,num ->
        println("acc: $acc -> num:$num")
        acc+num
    }
    println("sumStartingFrom10: $sumStartingFrom10")
}

fun stringFold(){
    val fruits= listOf("banana","apple","orange","pulp")
    val concatenated=fruits.fold("Fruits:"){ acc, fruit ->
        println("$acc $fruit")
        "$acc $fruit,"
    }
    println("concatenated: $concatenated")
}

