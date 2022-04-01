package com.example.cit0rustest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.cit0rustest.adapters.LayersRecyclerVIewAdapter
import com.example.cit0rustest.databinding.FragmentLayersBinding
import com.example.cit0rustest.utils.LayerItemTouchHelperCallBack
import com.example.cit0rustest.vm.BarState
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.vm.LayerListViewModel
import com.example.cit0rustest.vm.LayerViewModel

class LayersFragment : Fragment() {
    private val viewModel: LayerListViewModel by viewModels()
    private lateinit var adapter: LayersRecyclerVIewAdapter
    private val itemTouchHelper by lazy {
        ItemTouchHelper(LayerItemTouchHelperCallBack())
    }

    companion object {
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
        binding.barState = BarState()
        itemTouchHelper.attachToRecyclerView(binding.layerRecyclerView)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}