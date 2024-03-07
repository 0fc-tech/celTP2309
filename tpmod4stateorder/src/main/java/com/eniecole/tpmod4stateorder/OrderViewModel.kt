package com.eniecole.tpmod4stateorder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {
    private val _orderStateFlow = MutableStateFlow<OrderState>(OrderState.CartState)
    val orderStateFlow : StateFlow<OrderState> = _orderStateFlow

    fun order(){
        _orderStateFlow.value = OrderState.CartValidatedState
    }
    fun validateAddress(address: String){
        _orderStateFlow.value = OrderState.AddressFilledState(address)
    }
    fun pay(ccNumber: String){
        viewModelScope.launch {
            _orderStateFlow.value = OrderState.CreditCardFilledState(ccNumber)
            delay(2000)
            _orderStateFlow.value = OrderState.OrderFinishedSate
        }

    }
}

sealed class OrderState {
    data object CartState : OrderState()
    data object CartValidatedState : OrderState()
    data class AddressFilledState(val address: String) : OrderState()
    data class CreditCardFilledState(val ccNumber: String) : OrderState()
    data object OrderFinishedSate : OrderState()
}