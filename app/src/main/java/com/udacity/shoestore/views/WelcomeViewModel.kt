package com.udacity.shoestore.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val _eventStartShopping = MutableLiveData<Boolean>()
    val eventStartShopping: LiveData<Boolean>
        get() = _eventStartShopping

    private val _eventViewInstructions = MutableLiveData<Boolean>()
    val eventViewInstructions: LiveData<Boolean>
        get() = _eventViewInstructions

    fun onStartShopping(){
        _eventStartShopping.value = true
    }
    fun onViewInstructions(){
        _eventViewInstructions.value = true

    }
}