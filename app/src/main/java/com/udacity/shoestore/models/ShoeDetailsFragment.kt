package com.udacity.shoestore.models

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.views.ShoeDetailsViewModel
import com.udacity.shoestore.views.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details,
            container,
            false)

        setHasOptionsMenu(true)


        viewModel = ViewModelProvider(this)
            .get(ShoeDetailsViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.backButton.setOnClickListener{
            findNavController().navigateUp()
        }

        viewModel.eventAddShoe.observe(viewLifecycleOwner, Observer {
                eventAddItem ->
            if(eventAddItem){
                Log.i("ShoeDetails", "Shoe Details event Add Item")
                viewModel.onAddShoe()

                val action = ShoeDetailsFragmentDirections.
                actionShoeDetailsToShoeList(
                    viewModel.shoeName.value?:"",
                                           viewModel.shoeSize.value?:"",
                                           viewModel.shoeCompany.value?:"",
                                           viewModel.shoeDesc.value?:""
                )
                findNavController().navigate(action)
            }
        })


        return binding.root
    }

}

