package com.udacity.shoestore.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.R
import androidx.navigation.findNavController
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.views.InstructionsViewModel


class InstructionsFragment : Fragment() {

    private lateinit var viewModel: InstructionsViewModel
    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_instructions, container, false)

        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.setLifecycleOwner (this)
        binding.instructionsViewModel = viewModel


        viewModel.eventViewShoes.observe(viewLifecycleOwner, Observer{
            eventViewShoes ->
            if(eventViewShoes){
                val action = InstructionsFragmentDirections.actionInstructionsToShoeList(
                    "","","",""
                    )
                findNavController().navigate(action)
            }

        })

        return binding.root
    }



}