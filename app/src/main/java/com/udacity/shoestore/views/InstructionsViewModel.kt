package com.udacity.shoestore.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {
    private val _eventViewShoes = MutableLiveData<Boolean>()
    val eventViewShoes: LiveData<Boolean>
        get() = _eventViewShoes

    private val _eventAddShoes = MutableLiveData<Boolean>()
    val eventAddShoes: LiveData<Boolean>
        get() = _eventAddShoes

    fun onViewShoes(){
        _eventViewShoes.value = true
    }

    fun onAddShoes(){
        _eventAddShoes.value = true
    }


}