package com.udacity.shoestore.models

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.views.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit  var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.setLifecycleOwner (this)

        viewModel.eventLogin.observe(viewLifecycleOwner, Observer {
                eventLogin ->
         if (eventLogin){
             Log.i("LoginView", viewModel.editEmailContent.value?:"None")
             val action = LoginFragmentDirections.actionLoginToWelcome()
             findNavController().navigate(action)
             viewModel.onLoginComplete()
         }
//            else{
//
//         }

        })


        return binding.getRoot()

    }









}