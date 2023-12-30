package com.androidtechguru.kotlinpractice.rxjava.data

import com.androidtechguru.kotlinpractice.rxjava.data.model.ProductItem
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    fun getProducts():Observable<List<ProductItem>>

    @GET("/products")
    fun getProductList(): Flow<List<ProductItem>>
}