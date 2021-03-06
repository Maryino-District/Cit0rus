package com.example.cit0rustest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.cit0rustest.databinding.FragmentLayersBinding
import com.example.cit0rustest.utils.LayerItemTouchHelperCallBack
import com.example.cit0rustest.vm.LayerListViewModel

class LayersFragment : Fragment() {
    private val viewModel: LayerListViewModel by activityViewModels()
    private val itemTouchHelper by lazy {
        ItemTouchHelper(LayerItemTouchHelperCallBack(viewModel))
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
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentLayersBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this.activity
        binding.viewModel = viewModel
        viewModel.isDragButtonOn.observe(this.viewLifecycleOwner, object: Observer<Boolean> {
            override fun onChanged(t: Boolean?) {
                if (t == true) {
                    itemTouchHelper.attachToRecyclerView(binding.layerRecyclerView)
                } else {
                    itemTouchHelper.attachToRecyclerView(null)
                }
            }
        })
        return binding.root
    }

}