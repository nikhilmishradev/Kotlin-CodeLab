package com.androidtechguru.kotlinpractice.rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.IllegalArgumentException

fun main() {
    simpleObserver()
}

private fun simpleObserver() {
    val list = listOf("A", "B", "C", "D")
    var observable = Observable.fromIterable(list)

    observable = Observable.create<String>{
        it.onNext("Apple")
        it.onNext("Orange")
        it.onError(IllegalArgumentException("Error in Observable..."))
        it.onComplete()
    }

    observable.subscribe(object : Observer<String>{
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe()... $d")
        }

        override fun onError(e: Throwable) {
            println("onError()... -> $e")
        }

        override fun onComplete() {
            println("onComplete()...")
        }

        override fun onNext(t: String) {
            println("onNext()... $t")
        }
    })
}