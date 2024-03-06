package com.eniecole.mod4tpstateflowvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel: ViewModel() {
    private val _counterState = MutableStateFlow(0)
    val counterState: StateFlow<Int> = _counterState

    fun increment() {change(true)}
    fun decrement() {change(false)}

    private fun change(isPlus : Boolean){
        _counterState.value = if(isPlus) _counterState.value + 1 else _counterState.value - 1
    }
    fun triggerReset(){
        _counterState.value = 0
    }
}

//sealed class CounterState(var counter : Int = 0) {
//    data object Initial : CounterState(0)
//    class Changed(counter: Int) : CounterState(counter)
//    class Reset : CounterState(0)
//}