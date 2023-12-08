package com.androidtechguru.kotlinpractice

import kotlinx.coroutines.flow.flowOf


fun main(){

}

sealed class Result(){
    class Success(message: String="Success"): Result()
    class Failure(): Result()
}