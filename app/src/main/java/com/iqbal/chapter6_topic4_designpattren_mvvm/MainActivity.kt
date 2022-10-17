package com.iqbal.chapter6_topic4_designpattren_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iqbal.chapter6_topic4_designpattren_mvvm.databinding.ActivityMainBinding
import com.iqbal.chapter6_topic4_designpattren_mvvm.viewmodel.ViewModelCars

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : ViewModelCars

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    ShowDataCars()

    }



    fun ShowDataCars(){

        viewModel = ViewModelProvider(this).get(ViewModelCars::class.java)

        viewModel.getLivedataCars().observe(this, Observer {
            if (it != null) {
                binding.rvListCars.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                val adapter = AdapterCars(it)
                binding.rvListCars.adapter = adapter
            }
        })
        viewModel.callApiCars()

    }
}