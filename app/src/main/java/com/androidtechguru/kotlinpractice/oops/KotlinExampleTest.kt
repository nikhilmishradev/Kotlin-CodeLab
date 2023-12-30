package com.androidtechguru.kotlinpractice.oops

fun main() {
    printThePattern("abcd")
}

fun printThePattern(input: String){
    var patternString=input.reversed()
    var count = 0
    for(i in patternString){
        println(i.addSpaceToString(count++))
    }

}

fun Char.addSpaceToString(count: Int): String{
    var stringValue = this+""
    for(i in 0..count){
        stringValue+=" "
//        print(stringValue)
    }
    return stringValue.reversed()
}