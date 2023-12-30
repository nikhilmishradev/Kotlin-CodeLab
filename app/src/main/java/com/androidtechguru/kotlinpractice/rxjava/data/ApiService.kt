package com.androidtechguru.kotlinpractice.rxjava.data

import com.androidtechguru.kotlinpractice.rxjava.data.model.ProductItem
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getProductList(): List<ProductItem>
}