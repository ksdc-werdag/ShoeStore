package com.udacity.shoestore.views

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.ShoeItem
import android.util.Log

import androidx.databinding.PropertyChangeRegistry

class ShoeDetailsViewModel: ViewModel(), Observable {
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }


    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe: LiveData<Boolean>
        get() = _eventAddShoe


    @Bindable
    val shoeName = MutableLiveData<String>()

    @Bindable
    val shoeCompany = MutableLiveData<String>()
    @Bindable
    val shoeSize = MutableLiveData<String>()

    @Bindable
    val shoeDesc = MutableLiveData<String>()

    private val _shoeNameHelperText = MutableLiveData<String>()
    val shoeNameHelperText: LiveData<String>
        get() = _shoeNameHelperText

    private val _shoeCompanyHelperText = MutableLiveData<String>()
    val shoeCompanyHelperText: LiveData<String>
        get() = _shoeCompanyHelperText

    private val _shoeSizeHelperText = MutableLiveData<String>()
    val shoeSizeHelperText: LiveData<String>
        get() = _shoeSizeHelperText

    private val _shoeDescriptionHelperText = MutableLiveData<String>()
    val shoeDescriptionHelperText: LiveData<String>
        get() = _shoeDescriptionHelperText

    fun onAddShoe(){
        if( shoeName.value != ""  && shoeCompany.value!=""  && shoeSize.value!="" && shoeDesc.value !="" &&
            shoeName.value != null  && shoeCompany.value!=null  && shoeSize.value!=null && shoeDesc.value !=null){
            _eventAddShoe.value = true
            onAddShoesComplete()
        }
        else
        {
            _shoeNameHelperText.value="Please enter a value"
            _shoeCompanyHelperText.value ="Please enter a value"
            _shoeSizeHelperText.value = "Please enter a value"
            _shoeDescriptionHelperText.value ="Please enter a value"
        }

    }
    fun onAddShoesComplete(){
        _eventAddShoe.value = false
        Log.i("ShoeDetails", "onViewShoesComplete")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }


}
