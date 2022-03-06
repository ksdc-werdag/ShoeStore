package com.udacity.shoestore.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.views.WelcomeViewModel

class WelcomeFragment : Fragment() {
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: FragmentWelcomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false)
        viewModel = ViewModelProvider(this).get(
            WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel
        binding.setLifecycleOwner (this)

        viewModel.eventViewInstructions.observe(viewLifecycleOwner, Observer {
            eventStartShopping ->
            if(eventStartShopping){
                val action = WelcomeFragmentDirections.actionWelcomeToInstructions()
                findNavController().navigate(action)
//                findNavController().popBackStack()
        } })

        return binding.root

    }


}