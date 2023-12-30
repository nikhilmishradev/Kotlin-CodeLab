package com.androidtechguru.kotlinpractice.rxjava.data

import com.androidtechguru.kotlinpractice.rxjava.data.model.ProductItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiHelper {
    fun getProductList(): Flow<List<ProductItem>>
}