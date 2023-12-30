package com.androidtechguru.kotlinpractice.coroutines.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow


class FlowViewModel : ViewModel() {

//    private val _dataFlow: Flow<Int> = flow {  }
//val dataFlow: Flow<Int> = _dataFlow

    private val _dataFlow: MutableSharedFlow<Int> = MutableSharedFlow()
    val dataFlow: SharedFlow<Int> = _dataFlow

    fun fetchFlowData() {

        val sharedFlow = MutableSharedFlow<Int>(1)
        viewModelScope.launch {
            for (i in 0..5) {
                delay(1000L)
                _dataFlow.emit(i)
//                flow<Int> {
//                    emit(i)
//                    _dataFlow
//                }
            }
        }
    }
}