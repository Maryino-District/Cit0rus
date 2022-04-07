package com.example.cit0rustest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cit0rustest.fragments.LayersFragment
import com.example.cit0rustest.vm.LayerListViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_from_right,R.anim.slide_exit_to_right)
            .add(R.id.fragment_container, LayersFragment.getInstance(), "false")
            .commit()
    }
}