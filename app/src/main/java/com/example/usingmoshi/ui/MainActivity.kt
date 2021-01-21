package com.example.usingmoshi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.usingmoshi.adapter.SampleDataAdapter
import com.example.usingmoshi.databinding.ActivityMainBinding
import com.example.usingmoshi.viewmodels.SampleDataViewModel

// TODO: 1 elem jelenik csak meg
// TODO: Glide-dal betölteni a képeket is
class MainActivity : AppCompatActivity() {

    private val sampleDataAdapter by lazy {
        SampleDataAdapter()
    }

    private val sampleDataViewModel by lazy {
        ViewModelProvider(this).get(SampleDataViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        sampleDataViewModel.sampleData.observe(this, {
            sampleDataAdapter.submitList(it)
        })

        binding.sampleDataRecyclerview.apply {
            adapter = sampleDataAdapter
            setHasFixedSize(true)
        }
        setContentView(binding.root)
    }
}