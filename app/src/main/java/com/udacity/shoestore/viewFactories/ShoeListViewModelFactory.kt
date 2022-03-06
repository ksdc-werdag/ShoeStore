package com.udacity.shoestore.viewFactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.views.ShoeListViewModel

class ShoeListViewModelFactory (
    private val name: String,
                                private val size : String,
                                private val company: String,
                                private val description:String
                                )
    : ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ShoeListViewModel::class.java)){
                return ShoeListViewModel(
//                    name, size, company, description
                ) as T
        }
            throw IllegalArgumentException("Unknown ViewModel class")
    }
}