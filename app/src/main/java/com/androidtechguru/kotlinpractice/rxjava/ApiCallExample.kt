package com.androidtechguru.kotlinpractice.rxjava

import android.util.Log
import com.androidtechguru.kotlinpractice.coroutines.TAG
import com.androidtechguru.kotlinpractice.rxjava.data.RetrofitClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


fun main() {
    doApiCall()
}

fun doApiCall(updateUI: () -> Unit = {}) {
    val response = RetrofitClient.apiService
        .getProducts()
        .subscribeOn(Schedulers.io()) // subscribeOn() works as an UpStream means above its everything (every operators) will run in the same Thread (ex. here in IO Thread)
//        .observeOn(AndroidSchedulers.mainThread()) // observeOn() is down Stream means all below operators will run on this thread (ex. here is  MainThread())
        .subscribe { productList ->
            productList.iterator().forEachRemaining {
                val result =
                    "ProductItem: id:${it.id} - title:${it.title} - category:${it.category} - price:${it.price}".plus(
                        "\n"
                    )
                println("print --->>> $result")
                Log.v(TAG.verbose, result)
            }
            println("Response End...")
        }
}

// Schedulers == Dispatchers they tells the Observable that on which Thread it has to be executed
// Schedulers are basically a Thread Pools

//Dispose
// subscribeOn() works as an UpStream means above its everything (every operators) will run in the same Thread (ex. here in IO Thread)
// observeOn() is down Stream means all below operators will run on this thread (ex. here is  MainThread())
