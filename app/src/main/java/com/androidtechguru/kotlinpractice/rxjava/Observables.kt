package com.androidtechguru.kotlinpractice.rxjava

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    observable()
    single()
    maybe()
    completable()
    flowable()
}

fun observable() {
    /* Represents a stream of data that can emit zero or more items, and
    optionally terminates with either a completion or an error.
    Observable is commonly used when dealing with asynchronous data streams or events that can emit multiple items.
*/
    Observable.just("Titanic", "Conjuring", "Cars")
        .subscribe(
            { item -> println("latest item is $item") }, // This is onNext Block
            { error -> println("Error is $error") }, // This is onError Block
            { println("Task got completed") }  // This is onComplete Block
        ).dispose()
}

// Represents a stream that emits a single item or an error.
fun single() {
    /*
* Single type of Observable is used when you have to return a single item
Item will be returned when onSuccess will be called, If there is any error occurs
then it will call onError
*/
    Single.just("Example of Single Observable...")
        .subscribe(
            { result -> println("result is $result") },
            { error -> println("error is $error") }
        ).dispose()
}


// Represents a stream that can emit either a single item, no item at all, or terminate with an error.
fun maybe() {
    /*
 Maybe type of Observable is used when you have to return a single optional
 value as this is mutually exclusive with error, it means it will call either success
 or error and then onComplete
*/
    Maybe.just("Example of Maybe Observable")
        .subscribe(
            { result -> println("result is $result") },
            { error -> println("error is $error") },
            { println("Completed the task") }
        ).dispose()
}

// Represents an asynchronous operation that either completes successfully without emitting any item or terminates with an error.
fun completable() {
    val onComplete = Completable.create { completableEmiiter ->
        completableEmiiter.onComplete()
        completableEmiiter.onError(Exception("something went wrong!!!"))
    }
}

// Similar to Observable, but designed to handle backpressure,
// which is a mechanism to handle situations where an Observable is emitting data faster than the subscriber can consume.
fun flowable() {
    // It is very similar to Observable but it also handles the BackPressure mechanism.
    Flowable.just("Example of Flowable Observable...")
        .subscribe(
            { result -> println() },
            { error -> println() },
            { println() }
        ).dispose()
}