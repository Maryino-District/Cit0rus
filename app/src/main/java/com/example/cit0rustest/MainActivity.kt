package com.example.cit0rustest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.cit0rustest.fragments.LayersFragment
import com.example.cit0rustest.utils.LayerItemTouchHelperCallBack
import com.example.cit0rustest.vm.LayerListViewModel

class MainActivity : AppCompatActivity() {

    private val layerListViewModel: LayerListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LayersFragment.getInstance(), "false")
            .commit()
    }
}