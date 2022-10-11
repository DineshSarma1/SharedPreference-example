package com.example.daggerhiltmvvmpractice2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.daggerhiltmvvmpractice2.R
import com.example.daggerhiltmvvmpractice2.databinding.FragmentHomeBinding
import com.example.daggerhiltmvvmpractice2.viewModel.HomeViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        initViewModel()

    }

    fun initViewModel() {

        //initializing viewModel
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        //to provide click and access value of layout from ViewModel
        binding.viewModel = viewModel

        //observing newest value every time value changes
        viewModel.getUserName().observe(viewLifecycleOwner) { value ->
            value?.let {
                binding.resultTV.text = value
            }
        }
    }

}