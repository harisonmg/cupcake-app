package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {
    private val _quantity = MutableLiveData<Int>()
    private val _flavour = MutableLiveData<String>()
    private val _date = MutableLiveData<String>()
    private val _price = MutableLiveData<Double>()
    val dateOptions = getPickupOptions()

    // backing properties
    val quantity: LiveData<Int> = _quantity
    val flavour: LiveData<String> = _flavour
    val date: LiveData<String> = _date
    val price: LiveData<Double> = _price

    init {
        resetOrder()
    }

    private fun resetOrder() {
        _quantity.value = 0
        _flavour.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun hasNoFlavourSet(): Boolean {
        return _flavour.value.isNullOrEmpty()
    }

    fun setFlavour(desiredFlavour: String) {
        _flavour.value = desiredFlavour
    }

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }
}