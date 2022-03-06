package com.udacity.shoestore.models

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.util.Log
import com.udacity.shoestore.R
import android.view.LayoutInflater
import android.view.View
import com.udacity.shoestore.databinding.FragmentShoeCardBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.viewFactories.ShoeListViewModelFactory
import com.udacity.shoestore.views.ShoeListViewModel
import kotlinx.android.synthetic.main.fragment_shoe_list.*

//import kotlinx.android.synthetic.main.fragment_shoe_card.*
//import kotlinx.android.synthetic.main.fragment_shoe_list.*
import kotlin.reflect.KProperty


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModelFactory: ShoeListViewModelFactory
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        val shoeListFragmentArgs by navArgs<ShoeListFragmentArgs>()
        viewModelFactory = ShoeListViewModelFactory(
                                                shoeListFragmentArgs.name?:"Test",
                                                shoeListFragmentArgs.size?:"Test",
                                                shoeListFragmentArgs.company?:"Test",
                                                shoeListFragmentArgs.description?:"Test")


        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = viewModel
                setHasOptionsMenu(true)
        binding.lifecycleOwner = this
        viewModel.eventAddItem.observe(viewLifecycleOwner, Observer{
            eventAddItem ->

            if (eventAddItem){
                val action = ShoeListFragmentDirections.actionShoeListToShoeDetails()
                findNavController().navigate(action)
                viewModel.onAddItemComplete()

            }
        })
        insertNewShoe()
        return binding.root
    }

    private fun insertNewShoe() {
        viewModel.shoeListLiveData.observe(viewLifecycleOwner) { shoeList ->
            shoeList.takeLast(shoeList.size).forEach { shoe ->
                val shoeCardLayoutBinding = FragmentShoeCardBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.shoeListFrame,
                    false
                )

                shoeCardLayoutBinding.apply {
                    name.text = shoe.name
                    size.text = shoe.company
                    company.text = shoe.description
                    description.text = shoe.size
                }

                binding.shoeListFrame.addView(shoeCardLayoutBinding.root)
            }

        }
    }
}



