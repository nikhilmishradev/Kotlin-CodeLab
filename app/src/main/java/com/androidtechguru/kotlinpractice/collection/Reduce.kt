package com.androidtechguru.kotlinpractice.collection

//Purpose — Similar to fold, but it doesn't take an initial accumulator value.
// It uses the first element of the collection as the initial accumulator.
fun main() {
    numberReduce()
    rangeReduce()
}
fun numberReduce() {
    val numberList = listOf(1, 2, 3, 4)
    val reduce = numberList.reduce { acc, num ->
        println("acc: $acc -> num:$num")
        acc * num
    }
    println("Reduce: $reduce")
}

fun rangeReduce() {
    val rangeList = listOf(1..5, 3..8, 6..10)
//    val combinedRange = rangeList.reduce { acc, range -> acc.union(range) }
//    println(combinedRange)
}

infix fun <A, B, C> ((B) -> C).compose(g: (A) -> B): (A) -> C {
    return { x -> this(g(x)) }
}
