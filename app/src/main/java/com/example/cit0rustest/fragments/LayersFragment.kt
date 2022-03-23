package com.example.cit0rustest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cit0rustest.R
import com.example.cit0rustest.databinding.FragmentLayersBinding
import com.example.cit0rustest.vm.LayerListViewModel

class LayersFragment : Fragment() {
    private val viewModel: LayerListViewModel by viewModels()
    companion object { //factory
        fun getInstance() : LayersFragment{
            return LayersFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentLayersBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
}