package com.udacity.shoestore.views


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.ShoeItem


class ShoeListViewModel() : ViewModel() {

    private var _shoeList = MutableLiveData<List<ShoeItem>>()
    val shoeListLiveData: LiveData<List<ShoeItem>> get() = _shoeList
    private val shoeList = mutableListOf<ShoeItem>()

    private val _eventAddItem = MutableLiveData<Boolean>()
    val eventAddItem: LiveData<Boolean>
        get() = _eventAddItem

    private val _eventAddItemComplete = MutableLiveData<Boolean>()
    val eventAddItemComplete: LiveData<Boolean>
        get() = _eventAddItemComplete

    private val _eventNavigateBack = MutableLiveData<Boolean>()
    val eventNavigateBack: LiveData<Boolean>
        get() = _eventNavigateBack

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    fun onAddItem(){
        _eventAddItem.value = true
    }

    fun onAddItemComplete(){
        _eventAddItem.value = false
    }
    init {
        addNewShoe("name", "size", "company", "description")
        _counter.value = 1
    }
    fun addNewShoe(name:String,size: String, company: String, description: String ){
        var newShoe : ShoeItem = ShoeItem( name, size, company, description)
        addShoe(newShoe)
        Log.i("ShoeListView","Shoe List View Init Called")

    }

    fun addShoe(shoeItem: ShoeItem) {
        shoeList.add(shoeItem)
        Log.i("ShoeList", shoeList.toString())
    }





}