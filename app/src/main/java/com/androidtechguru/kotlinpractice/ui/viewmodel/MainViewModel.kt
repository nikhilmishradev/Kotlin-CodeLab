package com.androidtechguru.kotlinpractice.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidtechguru.kotlinpractice.coroutines.TAG
import com.androidtechguru.kotlinpractice.rxjava.data.ApiHelper
import com.androidtechguru.kotlinpractice.rxjava.data.ApiHelperImpl
import com.androidtechguru.kotlinpractice.rxjava.data.RetrofitClient
import com.androidtechguru.kotlinpractice.rxjava.data.model.ProductItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val _dataFlow: MutableStateFlow<List<ProductItem>> = MutableStateFlow(emptyList())
    var dataFlow: Flow<List<ProductItem>> = _dataFlow
    private val _data: MutableLiveData<List<ProductItem>> = MutableLiveData()
    val data: LiveData<List<ProductItem>> = _data
    private val _productList: MutableState<List<ProductItem>> =
        mutableStateOf<List<ProductItem>>(emptyList())
    val productList: State<List<ProductItem>> = _productList

    fun fetchData() {
        val apiHelper = ApiHelperImpl(RetrofitClient.apiProductService)
        viewModelScope.launch {
            apiHelper.getProductList().flowOn(Dispatchers.IO).catch { exception ->
                Log.v(TAG.verbose, exception.message ?: "exception")
            }
                .collect { productList ->
                    Log.v(TAG.verbose, "viewModel() : " + productList.count().toString())
                    _dataFlow.value = productList
                    _data.value = productList
                    _productList.value = productList
                }
        }
    }

    var productListResponse = Disposable.disposed()
    fun fetchDataRxJava() {
        productListResponse = RetrofitClient.apiService.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { productList ->
                _data.value = productList
                _productList.value = productList
            }

    }

    override fun onCleared() {
        super.onCleared()
        productListResponse.dispose()
    }
}