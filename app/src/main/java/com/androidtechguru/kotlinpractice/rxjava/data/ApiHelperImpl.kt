package com.androidtechguru.kotlinpractice.rxjava.data

import com.androidtechguru.kotlinpractice.rxjava.data.model.ProductItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override fun getProductList(): Flow<List<ProductItem>>   = flow{
        emit(apiService.getProductList())
    }


}