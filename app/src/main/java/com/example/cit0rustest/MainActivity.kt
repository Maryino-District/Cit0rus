package com.example.cit0rustest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cit0rustest.fragments.LayersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LayersFragment.getInstance(), "false")
            .commit()

    }

}