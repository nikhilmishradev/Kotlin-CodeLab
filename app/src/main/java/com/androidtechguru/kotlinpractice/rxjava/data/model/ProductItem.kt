package com.androidtechguru.kotlinpractice.rxjava.data.model

data class ProductItem(
    val category: String = "cat",
    val description: String = "desc",
    val id: Int = 1,
    val image: String = "",
    val price: Double = 1.0,
    val rating: Rating? = null,
    val title: String = "title"
)