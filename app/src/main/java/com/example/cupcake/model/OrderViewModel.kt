package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _quantity = MutableLiveData<Int>(0)
    private val _flavour = MutableLiveData<String>("")
    private val _date = MutableLiveData<String>("")
    private val _price = MutableLiveData<Double>(0.0)

    // backing properties
    val quantity: LiveData<Int> = _quantity
    val flavour: LiveData<String> = _flavour
    val date: LiveData<String> = _date
    val price: LiveData<Double> = _price

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavour(desiredFlavour: String) {
        _flavour.value = desiredFlavour
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }
}