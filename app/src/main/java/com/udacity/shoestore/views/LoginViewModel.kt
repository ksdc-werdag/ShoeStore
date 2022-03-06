package com.udacity.shoestore.views


import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.databinding.Bindable


class LoginViewModel: ViewModel() , Observable{
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }
    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private val _helperTextEmail= MutableLiveData<String>()
    val helperTextEmail: LiveData<String>
        get() = _helperTextEmail

    private val _helperTextPassword= MutableLiveData<String>()
     val helperTextPassword: LiveData<String>
     get() = _helperTextPassword

    @Bindable
    val editEmailContent = MutableLiveData<String>()

    @Bindable
    val editPasswordContent = MutableLiveData<String>()

    init {
        Log.i("LoginViewModel", "LoginViewModel created!")

    }

    override fun onCleared() {
        super.onCleared()

        Log.i("LoginViewModel", "LoginViewModel destroyed!")
    }


    fun onLogin(){
        val email: String
        val password: String
        email = editEmailContent.value?:"None"
        Log.i("LoginView Email ", email )
        password = editPasswordContent.value?:"Blank"
        Log.i ("LoginView Password" , password)
        if (email!="None" && password!="Blank" && email!="" && password!="") {
            _eventLogin.value = true }
        else{
            _helperTextEmail.value="Please enter valid Email"
            _helperTextPassword.value="Please Enter Password"}
    }
    fun onLoginComplete(){
        _eventLogin.value = false
        Log.i("LoginView","Login Complete")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

}